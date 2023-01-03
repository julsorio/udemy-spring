package com.udemy.spring.coach;

public class VolleyballCoach implements Coach {

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
		// TODO Auto-generated method stub
		return null;
	}
	
	//init
	public void doMyStartUpStuff() {
		System.out.println("doMyStartUpStuff()");
	}
	
	//destroy
	public void doMyCleanStuff() {
		System.out.println("doMyCleanStuff()");
	}
}
