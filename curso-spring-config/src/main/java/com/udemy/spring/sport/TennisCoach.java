package com.udemy.spring.sport;

import org.springframework.stereotype.Component;

import com.udemy.spring.coach.Coach;

@Component
public class TennisCoach implements Coach {
	
	@Override
	public String getDailyAdvice() {
		return "10 minutes slice practice";
	}

	@Override
	public String getFortune() {
		return "fortune";
	}

}
