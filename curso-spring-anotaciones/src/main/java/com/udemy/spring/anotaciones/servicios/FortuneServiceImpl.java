package com.udemy.spring.anotaciones.servicios;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		return "fortune!";
	}
	
}
