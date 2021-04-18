package com.ccarlosf.rabbit.producer.broker;


import com.ccarlosf.rabbit.api.Message;
import com.ccarlosf.rabbit.api.MessageProducer;
import com.ccarlosf.rabbit.api.MessageType;
import com.ccarlosf.rabbit.api.SendCallback;
import com.ccarlosf.rabbit.api.exception.MessageRunTimeException;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 	$ProducerClient 发送消息的实际实现类
 *
 */
@Component
public class ProducerClient implements MessageProducer {

	@Autowired
	private RabbitBroker rabbitBroker;

	@Override
	public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {

	}

	@Override
	public void send(Message message) throws MessageRunTimeException {
		Preconditions.checkNotNull(message.getTopic());
		String messageType = message.getMessageType();
		switch (messageType) {
			case MessageType.RAPID:
				rabbitBroker.rapidSend(message);
				break;
			case MessageType.CONFIRM:
				rabbitBroker.confirmSend(message);
				break;
			case MessageType.RELIANT:
				rabbitBroker.reliantSend(message);
				break;
			default:
				break;
		}

	}

	@Override
	public void send(List<Message> messages) throws MessageRunTimeException {

	}
}
