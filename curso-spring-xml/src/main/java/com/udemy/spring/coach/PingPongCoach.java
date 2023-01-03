package com.udemy.spring.coach;

import com.udemy.spring.service.AdviceService;

public class PingPongCoach implements Coach {
	
	private AdviceService adviceService;

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
		return adviceService.giveAdvice();
	}

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
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
