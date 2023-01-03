package com.udemy.spring.anotaciones.coach;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "slice practice for 10 minutes";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
