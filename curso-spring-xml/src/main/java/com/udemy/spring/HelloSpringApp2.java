package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.BasketballCoach;

public class HelloSpringApp2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BasketballCoach coach = context.getBean("myCoach6", BasketballCoach.class);
		System.out.println(coach.getAdvice());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeamName());
		
		context.close();
	}

}
