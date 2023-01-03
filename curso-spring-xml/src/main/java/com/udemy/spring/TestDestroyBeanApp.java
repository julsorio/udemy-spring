package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.Coach;

public class TestDestroyBeanApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("destroyPrototype-applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		context.close();
	}

}
