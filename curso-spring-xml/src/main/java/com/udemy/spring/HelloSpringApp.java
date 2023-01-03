package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.ChessCoach;
import com.udemy.spring.coach.Coach;
import com.udemy.spring.coach.PingPongCoach;

public class HelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		Coach cyclingCoach = context.getBean("myCoach2", Coach.class);
		System.out.println(cyclingCoach.getDailyWorkout());
		
		Coach soccerCoach = context.getBean("myCoach3", Coach.class);
		System.out.println(soccerCoach.getDailyWorkout());
		System.out.println(soccerCoach.getDailyFortune());
		
		PingPongCoach pingPongCoach = context.getBean("myCoach4", PingPongCoach.class);
		System.out.println(pingPongCoach.getAdvice());
		
		ChessCoach chessCoach = context.getBean("myCoach5", ChessCoach.class);
		System.out.println(chessCoach.getEmailAddress());
		System.out.println(chessCoach.getTeamName());
		
		context.close();
	}

}
