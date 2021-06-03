package com.ccarlos.distributedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccarlos.distributedemo.dao")
public class DistributeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeDemoApplication.class, args);
    }

}
