package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addAccount() {
		System.out.println(getClass() + " addAccount() ");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " goToSleep()");
	}
}
