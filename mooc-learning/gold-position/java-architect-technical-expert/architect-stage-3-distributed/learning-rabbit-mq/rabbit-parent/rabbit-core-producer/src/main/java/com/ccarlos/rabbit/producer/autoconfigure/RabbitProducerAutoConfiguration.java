package com.ccarlos.rabbit.producer.autoconfigure;

import com.ccarlos.rabbit.task.annotation.EnableElasticJob;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 	$RabbitProducerAutoConfiguration 自动装配 
 *
 */
@EnableElasticJob
@Configuration
@ComponentScan({"com.ccarlos.rabbit.producer.*"})
public class RabbitProducerAutoConfiguration {


}
