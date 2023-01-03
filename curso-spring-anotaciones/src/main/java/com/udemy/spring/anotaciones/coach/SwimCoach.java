package com.udemy.spring.anotaciones.coach;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "daily workout";
	}

	@Override
	public String getFortune() {
		return "default fortune";
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
