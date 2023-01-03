package com.udemy.spring.service;

import java.util.Random;

public class RandomFortuneServiceImpl implements RandomFortuneService {

	@Override
	public String getRandomFortune() {
		String[] fortuneArray = { "fortune 1", "fortune 2", "fortune 3" };

		int min = 1;
		int max = 2;
		int result = 0;
		Random rand = new Random();
		result = rand.nextInt((max - min) + 1) + min;

		return fortuneArray[result];
	}

}
