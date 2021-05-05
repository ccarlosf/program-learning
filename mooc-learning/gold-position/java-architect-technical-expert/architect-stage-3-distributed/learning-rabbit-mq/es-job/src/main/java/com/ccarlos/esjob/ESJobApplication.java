package com.ccarlos.esjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@EnableElasticJob
@SpringBootApplication
@ComponentScan(basePackages = {"com.ccarlos.esjob.*", "com.ccarlos.esjob.service.*", "com.ccarlos.esjob.annotation.*", "com.ccarlos.esjob.task.*"})
public class ESJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESJobApplication.class, args);
	}
}
