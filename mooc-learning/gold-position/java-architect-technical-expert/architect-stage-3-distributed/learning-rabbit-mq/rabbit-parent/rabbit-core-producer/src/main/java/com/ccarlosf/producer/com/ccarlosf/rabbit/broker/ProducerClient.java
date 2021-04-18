package com.ccarlosf.producer.com.ccarlosf.rabbit.broker;


import com.ccarlosf.rabbit.api.Message;
import com.ccarlosf.rabbit.api.MessageProducer;
import com.ccarlosf.rabbit.api.SendCallback;
import com.ccarlosf.rabbit.api.exception.MessageRunTimeException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 	$ProducerClient 发送消息的实际实现类
 *
 */
@Component
public class ProducerClient implements MessageProducer {

	@Override
	public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {

	}

	@Override
	public void send(Message message) throws MessageRunTimeException {

	}

	@Override
	public void send(List<Message> messages) throws MessageRunTimeException {

	}
}
