package com.udemy.spring.coach;

import com.udemy.spring.service.ScopeDemoService;

public class TennisCoach implements Coach {
	
	private ScopeDemoService scopeDemoService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		return scopeDemoService.test();
	}

	public void setScopeDemoService(ScopeDemoService scopeDemoService) {
		this.scopeDemoService = scopeDemoService;
	}

	
}
