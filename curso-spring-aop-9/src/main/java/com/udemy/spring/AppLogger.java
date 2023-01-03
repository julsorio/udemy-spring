package com.udemy.spring;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
import com.udemy.spring.service.TrafficFortuneService;

/**
 * Hello world!
 *
 */
public class AppLogger {
	
	private static Logger logger = Logger.getLogger(AppLogger.class.getName());
	
	public static void main(String[] args) {
		logger.info("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean(TrafficFortuneService.class);
		
		logger.info("calling fortune service");
		String data = fortuneService.getFortune();
		logger.info("fortune: " + data);
		
		context.close();
	}
}
