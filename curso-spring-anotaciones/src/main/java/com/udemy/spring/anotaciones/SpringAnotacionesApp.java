package com.udemy.spring.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.anotaciones.coach.ArcheryCoach;
import com.udemy.spring.anotaciones.coach.Coach;
import com.udemy.spring.anotaciones.coach.SwimCoach;

public class SpringAnotacionesApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach myCoach = context.getBean("bowlingCoach", Coach.class);
		System.out.println(myCoach.getFortune());

		Coach myCoach2 = context.getBean("cyclingCoach", Coach.class);
		System.out.println(myCoach2.getDailyWorkout());
		System.out.println(myCoach2.getFortune());

		Coach myCoach3 = context.getBean("runningCoach", Coach.class);
		System.out.println(myCoach3.getDailyWorkout());
		System.out.println(myCoach3.getFortune());
		
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getFortune());
		System.out.println(swimCoach.getTeam());
		
		ArcheryCoach myCoach4 = context.getBean("archeryCoach", ArcheryCoach.class);

		context.close();
	}

}
