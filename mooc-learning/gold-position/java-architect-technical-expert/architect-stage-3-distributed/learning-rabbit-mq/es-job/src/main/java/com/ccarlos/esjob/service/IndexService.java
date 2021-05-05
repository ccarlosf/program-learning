package com.ccarlos.esjob.service;

import org.springframework.stereotype.Service;

import com.ccarlos.esjob.annotation.JobTrace;

@Service
public class IndexService {

	@JobTrace
	public void tester(String name) {
		System.err.println("name: " + name);
	}
}
