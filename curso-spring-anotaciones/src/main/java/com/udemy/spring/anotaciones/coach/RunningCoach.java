package com.udemy.spring.anotaciones.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.spring.anotaciones.servicios.FortuneService;

@Component
public class RunningCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "run 10k";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune()	;
	}

}
