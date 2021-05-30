package com.ccarlos.collector.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController {


	/**
	 * [%d{yyyy-MM-dd'T'HH:mm:ss.SSSZZ}]
	 * [%level{length=5}]
	 * [%thread-%tid]
	 * [%logger]
	 * [%X{hostName}]
	 * [%X{ip}]
	 * [%X{applicationName}]
	 * [%F,%L,%C,%M]
	 * [%m] ## '%ex'%n
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index() {

		log.info("我是一条info日志");
		
		log.warn("我是一条warn日志");

		log.error("我是一条error日志");
		
		return "idx";
	}
}
