package com.udemy.spring.anotaciones.coach;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class BoxingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "jab exercise for 10 minutes";
	}

	@Override
	public String getFortune() {
		return "go go go";
	}

}
