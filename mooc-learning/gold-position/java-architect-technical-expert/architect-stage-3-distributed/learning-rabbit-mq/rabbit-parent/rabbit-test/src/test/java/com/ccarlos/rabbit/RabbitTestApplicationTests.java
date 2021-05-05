package com.ccarlos.rabbit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccarlos.rabbit.api.Message;
import com.ccarlos.rabbit.api.MessageType;
import com.ccarlos.rabbit.producer.broker.ProducerClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTestApplicationTests {

	@Autowired
	private ProducerClient producerClient;
	
	@Test
	public void testProducerClient() throws Exception {
		
		for(int i = 0 ; i < 1; i ++) {
			String uniqueId = UUID.randomUUID().toString();
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("name", "张三");
			attributes.put("age", "18");
			Message message = new Message(
					uniqueId, 
					"exchange-2", 
					"springboot.abc", 
					attributes, 
					0);
			message.setMessageType(MessageType.RELIANT);
//			message.setDelayMills(15000);
			producerClient.send(message);			
		}

		Thread.sleep(1000000);
	}

}
