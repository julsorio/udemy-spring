package com.udemy.spring.servicios;

public class TeamFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "team fortune service";
	}

}
