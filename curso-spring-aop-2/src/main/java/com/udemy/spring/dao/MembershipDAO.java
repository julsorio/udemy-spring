package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + " addAccount()");
	}
}
