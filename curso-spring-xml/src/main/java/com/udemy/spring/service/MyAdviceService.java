package com.udemy.spring.service;

public class MyAdviceService implements AdviceService {

	@Override
	public String giveAdvice() {
		return "Test Advice";
	}

}
