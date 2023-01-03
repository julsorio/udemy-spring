package com.udemy.spring.servicios;

public class SadFortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		return "today is a sad day";
	}

}
