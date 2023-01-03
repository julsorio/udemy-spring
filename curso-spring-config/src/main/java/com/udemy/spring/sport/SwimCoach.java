package com.udemy.spring.sport;

import com.udemy.spring.coach.Coach;
import com.udemy.spring.servicios.FortuneService;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyAdvice() {
		return "swim 100 meters";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
