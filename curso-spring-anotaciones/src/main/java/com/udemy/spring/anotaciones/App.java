package com.udemy.spring.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.anotaciones.coach.Coach;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach myCoach = context.getBean("myCoach", Coach.class);
		System.out.println(myCoach.getDailyWorkout());

		//default bean id
		//no name in the Component annotation
		Coach myCoach2 = context.getBean("soccerCoach", Coach.class);
		System.out.println(myCoach2.getDailyWorkout());

		context.close();
	}
}
