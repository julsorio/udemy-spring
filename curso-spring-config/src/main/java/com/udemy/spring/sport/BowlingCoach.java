package com.udemy.spring.sport;

import com.udemy.spring.coach.TeamCoach;
import com.udemy.spring.servicios.FortuneService;

public class BowlingCoach implements TeamCoach {
	
	private FortuneService teamFortuneService;
	
	public BowlingCoach(FortuneService teamFortuneService) {
		this.teamFortuneService = teamFortuneService;
	}

	@Override
	public String getFortune() {
		return teamFortuneService.getFortune();
	}

}
