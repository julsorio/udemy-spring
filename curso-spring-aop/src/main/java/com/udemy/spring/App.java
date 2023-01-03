package com.udemy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.aop.dao.Account;
import com.udemy.spring.aop.dao.AccountDAO;
import com.udemy.spring.aop.dao.MembershipDAO;
import com.udemy.spring.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		accountDAO.addAccount();
		accountDAO.addAccount(new Account());
		accountDAO.addAccount(new Account(), true);
		accountDAO.doWork();
		
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		
		context.close();
	}
}
