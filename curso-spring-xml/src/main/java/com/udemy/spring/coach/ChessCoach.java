package com.udemy.spring.coach;

import com.udemy.spring.service.AdviceService;

public class ChessCoach implements Coach {
	private String emailAddress;
	private String teamName;
	
	private AdviceService adviceService;
	
	@Override
	public String getDailyWorkout() {
		return "to play 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return "go for it!";
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
