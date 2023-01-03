package com.udemy.spring.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Expect heavy traffic this morning";
	}

	public String getFortuneException(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Major accident! highway is closed");
		}

		return getFortune();
	}

	public String getFortuneException2(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Major accident! highway is closed");
		}

		return getFortune();
	}
}
