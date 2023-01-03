package com.udemy.spring.service;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		return "database fortune service";
	}

}
