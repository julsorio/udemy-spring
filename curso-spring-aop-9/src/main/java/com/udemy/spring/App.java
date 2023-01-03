package com.udemy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
import com.udemy.spring.service.TrafficFortuneService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean(TrafficFortuneService.class);
		
		System.out.println("calling fortune service");
		String data = fortuneService.getFortune();
		System.out.println("fortune: " + data);
		
		context.close();
	}
}
