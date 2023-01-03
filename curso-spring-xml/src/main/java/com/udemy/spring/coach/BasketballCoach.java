package com.udemy.spring.coach;

import com.udemy.spring.service.AdviceService;

public class BasketballCoach implements Coach {
	private String emailAddress;
	private String teamName;

	private AdviceService adviceService;

	@Override
	public String getDailyWorkout() {
		return "10 minutes 3 points shoots";
	}

	@Override
	public String getDailyFortune() {
		return "go go go";
	}

	@Override
	public String getAdvice() {
		return adviceService.giveAdvice();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	@Override
	public String getRandomeFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

}
