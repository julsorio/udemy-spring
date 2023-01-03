package com.udemy.spring.anotaciones.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.spring.anotaciones.servicios.ActivityFortuneService;

@Component
public class GolfCoach implements Coach {
	@Autowired
	private ActivityFortuneService activityFortune;

	@Override
	public String getDailyWorkout() {
		return "daily workout";
	}

	@Override
	public String getFortune() {
		return activityFortune.getFortune();
	}

}
