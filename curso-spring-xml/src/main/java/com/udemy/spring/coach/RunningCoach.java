package com.udemy.spring.coach;

import com.udemy.spring.service.RandomFortuneService;

public class RunningCoach implements Coach {
	
	private RandomFortuneService randomFortune;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAdvice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRandomeFortune() {
		return randomFortune.getRandomFortune();
	}

	public void setRandomFortune(RandomFortuneService randomFortune) {
		this.randomFortune = randomFortune;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
