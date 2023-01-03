package com.udemy.spring.servicios;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		return "fortune!";
	}
	
}
