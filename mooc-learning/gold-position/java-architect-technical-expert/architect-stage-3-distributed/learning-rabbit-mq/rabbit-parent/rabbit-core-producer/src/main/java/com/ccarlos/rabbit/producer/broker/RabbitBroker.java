package com.ccarlos.rabbit.producer.broker;


import com.ccarlos.rabbit.api.Message;

/**
 * 	$RabbitBroker 具体发送不同种类型消息的接口
 *
 */
public interface RabbitBroker {
	
	void rapidSend(Message message);
	
	void confirmSend(Message message);
	
	void reliantSend(Message message);
	
	void sendMessages();
	
}
