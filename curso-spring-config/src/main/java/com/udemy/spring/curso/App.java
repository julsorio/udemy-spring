package com.udemy.spring.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.coach.Coach;
import com.udemy.spring.coach.TeamCoach;
import com.udemy.spring.config.AppConfig;
import com.udemy.spring.sport.SoccerCoach;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		/*Coach myCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(myCoach.getDailyAdvice());
		System.out.println(myCoach.getFortune());*/
		
		Coach myCoach2 = context.getBean("swimCoach", Coach.class);
		System.out.println(myCoach2.getDailyAdvice());
		System.out.println(myCoach2.getFortune());
		
		SoccerCoach myCoach3 = context.getBean("soccerCoach", SoccerCoach.class);
		System.out.println(myCoach3.getEmail());
		System.out.println(myCoach3.getTeam());
		
		TeamCoach bowlingCoach = context.getBean("bowlingCoach", TeamCoach.class);
		System.out.println(bowlingCoach.getFortune());
		
		context.close();
	}
}
