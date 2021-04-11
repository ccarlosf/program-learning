package com.ccarlosf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
@MapperScan(basePackages = "com.ccarlosf.mapper")
@ComponentScan(basePackages = {"com.ccarlosf", "org.n3r.idworker"})
public class FoodieFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodieFileApplication.class, args);
    }

}
