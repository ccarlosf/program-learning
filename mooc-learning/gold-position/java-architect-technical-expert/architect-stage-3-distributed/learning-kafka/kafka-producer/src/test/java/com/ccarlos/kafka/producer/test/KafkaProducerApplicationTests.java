package com.ccarlos.kafka.producer.test;

import com.ccarlos.kafka.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerApplicationTests {

	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@Test
	public void send() throws InterruptedException {
		
		String topic = "topic03";
		for(int i=0; i < 1000; i ++) {
			kafkaProducerService.sendMessage(topic, "hello kafka" + i);
			Thread.sleep(5);
		}
		
		Thread.sleep(Integer.MAX_VALUE);
		
	}	
	
}
