package com.udemy.spring.service;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {
	
	@Override
	public String getFortune() {
		return "fortune service";
	}

}
