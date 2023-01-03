package com.udemy.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		Account account1 = new Account("name 1", "level 1");
		Account account2 = new Account("name 2", "level 2");
		Account account3 = new Account("name 3", "level 3");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
}
