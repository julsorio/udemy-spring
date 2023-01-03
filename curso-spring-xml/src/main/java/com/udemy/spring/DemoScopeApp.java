package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.Coach;

public class DemoScopeApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach coach2 = context.getBean("myCoach", Coach.class);
		
		boolean result = (coach == coach2);
		System.out.println("poining to the same object: " + result);
		
		System.out.println("coach: " + coach);
		System.out.println("coach2: " + coach2);
		
		Coach coach3 = context.getBean("myCoach2", Coach.class);
		Coach coach4 = context.getBean("myCoach2", Coach.class);

		boolean result2 = (coach3 == coach4);
		System.out.println("poining to the same object: " + result2);
		
		System.out.println("coach: " + coach3);
		System.out.println("coach2: " + coach4);
		context.close();
	}

}
