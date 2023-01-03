package com.udemy.spring.coach;

import org.springframework.beans.factory.DisposableBean;

public class BadmintonCoach implements Coach, DisposableBean {

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

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() method");
	}

}
