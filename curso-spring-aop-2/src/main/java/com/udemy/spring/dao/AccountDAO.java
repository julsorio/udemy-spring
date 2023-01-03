package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + " addAccount()");
	}
	
	public void doWork() {
		System.out.println(getClass() + " doWork()");
	}
}
