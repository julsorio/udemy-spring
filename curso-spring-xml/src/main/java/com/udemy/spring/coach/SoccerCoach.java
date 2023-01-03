package com.udemy.spring.coach;

import com.udemy.spring.service.FortuneService;

public class SoccerCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Defense drills";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getAdvice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRandomeFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

}
