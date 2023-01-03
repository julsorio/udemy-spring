package com.udemy.spring;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
import com.udemy.spring.service.TrafficFortuneService;

/**
 * Hello world!
 *
 */
public class AppLoggerHandleException {
	
	private static Logger logger = Logger.getLogger(AppLoggerHandleException.class.getName());
	
	public static void main(String[] args) {
		logger.info("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean(TrafficFortuneService.class);
		
		logger.info("calling fortune service");
		
		boolean tripWire = true;
		
		String data = fortuneService.getFortuneException(tripWire);
		logger.info("fortune: " + data);
		
		context.close();
	}
}
