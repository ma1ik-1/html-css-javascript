package com.qa.springdemo;

import org.apache.catalina.startup.ContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class WeekOneApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeekOneApplication.class, args);
	
		Object byName = context.getBean("greeting");
		
		System.out.println(byName);
	}
	
	@Bean
	public String greeting() {
		return "hello worl";
	}

}
