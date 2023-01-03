package com.udemy.spring.anotaciones.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.spring.anotaciones.servicios.FortuneService;

@Component
public class BowlingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//constructor injection
	@Autowired
	public BowlingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "spare practice";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
