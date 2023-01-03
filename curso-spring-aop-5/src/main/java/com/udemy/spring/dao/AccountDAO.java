package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + " addAccount() ");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + " addAccount(Account account) ");
	}
	
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + " addAccount(Account account, boolean vip)");
	}
	
	public void doWork() {
		System.out.println(getClass() + " doWork()");
	}
}
