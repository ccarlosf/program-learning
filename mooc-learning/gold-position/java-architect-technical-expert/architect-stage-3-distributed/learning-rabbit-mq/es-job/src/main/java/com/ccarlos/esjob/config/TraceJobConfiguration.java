package com.ccarlos.esjob.config;

import org.springframework.context.annotation.Bean;

import com.ccarlos.esjob.annotation.JobTraceInterceptor;

//@Configuration
public class TraceJobConfiguration {

	@Bean
	public JobTraceInterceptor jobTraceInterceptor() {
		System.err.println("init --------------->");
		return new JobTraceInterceptor();
	}
	
}
