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
		
		List<Account> accountsList = null;
		
		try {
			accountsList = accountDAO.findAccounts(false);
		} catch (Exception e) {
			System.out.println("the exception: " + e);
		}
		
		System.out.println("accounts list: " + accountsList);
		
		context.close();
	}
}
