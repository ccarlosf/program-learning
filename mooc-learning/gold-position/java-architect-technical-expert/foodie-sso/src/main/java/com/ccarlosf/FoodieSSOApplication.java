package com.ccarlosf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

// 跳转security的拦截登录
@SpringBootApplication
// 扫描 mybatis 通用 mapper 所在的包目录
@MapperScan(basePackages = "com.ccarlosf.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.ccarlosf", "org.n3r.idworker"})
public class FoodieSSOApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FoodieSSOApplication.class, args);
	}
}
