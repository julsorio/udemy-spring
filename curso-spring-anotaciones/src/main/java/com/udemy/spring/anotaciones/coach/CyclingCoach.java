package com.udemy.spring.anotaciones.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.spring.anotaciones.servicios.FortuneService;

@Component
public class CyclingCoach implements Coach {
	
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "6 kms uphill repetitions";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	//injection on setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	

}
