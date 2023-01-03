package com.udemy.spring.sport;

import org.springframework.beans.factory.annotation.Value;

import com.udemy.spring.coach.Coach;

public class SoccerCoach implements Coach {

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyAdvice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
