package com.udemy.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
import com.udemy.spring.dao.Account;
import com.udemy.spring.dao.AccountDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		List<Account> accountList = null;
		
		try {
			accountList = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
