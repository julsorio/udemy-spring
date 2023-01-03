package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount() {
		System.out.println(getClass() + " addAccount()");
	}

	public void doWork() {
		System.out.println(getClass() + " doWork()");
	}

	public String getName() {
		System.out.println(getClass() + " getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
