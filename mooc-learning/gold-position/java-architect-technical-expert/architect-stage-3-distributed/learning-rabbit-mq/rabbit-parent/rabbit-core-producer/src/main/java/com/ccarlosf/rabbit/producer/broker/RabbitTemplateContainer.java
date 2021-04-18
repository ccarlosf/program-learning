package com.ccarlosf.rabbit.producer.broker;

import com.ccarlosf.rabbit.api.Message;
import com.ccarlosf.rabbit.api.MessageType;
import com.ccarlosf.rabbit.api.exception.MessageRunTimeException;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 	$RabbitTemplateContainer池化封装
 * 	每一个topic 对应一个RabbitTemplate
 *	1.	提高发送的效率
 * 	2. 	可以根据不同的需求制定化不同的RabbitTemplate, 比如每一个topic 都有自己的routingKey规则
 * @author ccarlos
 */
@Slf4j
@Component
public class RabbitTemplateContainer implements RabbitTemplate.ConfirmCallback {

	private Map<String /* TOPIC */, RabbitTemplate> rabbitMap = Maps.newConcurrentMap();
	
	private Splitter splitter = Splitter.on("#");

	@Autowired
	private ConnectionFactory connectionFactory;
	
	public RabbitTemplate getTemplate(Message message) throws MessageRunTimeException {
		Preconditions.checkNotNull(message);
		String topic = message.getTopic();
		RabbitTemplate rabbitTemplate = rabbitMap.get(topic);
		if(rabbitTemplate != null) {
			return rabbitTemplate;
		}
		log.info("#RabbitTemplateContainer.getTemplate# topic: {} is not exists, create one", topic);
		
		RabbitTemplate newTemplate = new RabbitTemplate(connectionFactory);
		newTemplate.setExchange(topic);
		newTemplate.setRoutingKey(message.getRoutingKey());
		newTemplate.setRetryTemplate(new RetryTemplate());
		
		// 对于message的序列化方式
		// newTemplate.setMessageConverter(messageConverter);
		
		String messageType = message.getMessageType();
		if(!MessageType.RAPID.equals(messageType)) {
			newTemplate.setConfirmCallback(this);
		}
		
		rabbitMap.putIfAbsent(topic, newTemplate);
		
		return rabbitMap.get(topic);
	}

	/**
	 * 	无论是 confirm 消息 还是 reliant 消息 ，发送消息以后 broker都会去回调confirm
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		// 	具体的消息应答
		List<String> strings = splitter.splitToList(correlationData.getId());
		String messageId = strings.get(0);
		long sendTime = Long.parseLong(strings.get(1));
		if(ack) {
			//	当Broker 返回ACK成功时, 就是更新一下日志表里对应的消息发送状态为 SEND_OK

			log.info("send message is OK, confirm messageId: {}, sendTime: {}", messageId, sendTime);
		} else {
			log.error("send message is Fail, confirm messageId: {}, sendTime: {}", messageId, sendTime);
			
		}
	}
}
