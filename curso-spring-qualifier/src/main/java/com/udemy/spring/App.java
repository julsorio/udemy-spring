package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.Coach;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getFortune());

		context.close();
	}
}
