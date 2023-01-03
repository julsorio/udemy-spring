package com.udemy.spring.anotaciones.coach;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "dribbling practice for 10 minutes";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
