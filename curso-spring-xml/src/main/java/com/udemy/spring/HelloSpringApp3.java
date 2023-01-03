package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.RunningCoach;

public class HelloSpringApp3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		RunningCoach runningCoach = context.getBean("myCoach7", RunningCoach.class);
		System.out.println(runningCoach.getRandomeFortune());
		
		context.close();
	}

}
