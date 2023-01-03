package com.udemy.spring.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.anotaciones.coach.Coach;

public class ActividadApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*Coach coach = context.getBean("golfCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());*/
		
		Coach coach = context.getBean("sailingCoach", Coach.class);
		System.out.println(coach.getFortune());

		context.close();
	}

}
