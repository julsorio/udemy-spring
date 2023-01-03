package com.udemy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
import com.udemy.spring.dao.AccountDAO;
import com.udemy.spring.dao.MembershipDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		
		accountDAO.setName("the name");
		accountDAO.setServiceCode("the service code");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		accountDAO.addAccount();
		membershipDAO.addAccount();
		
		
		context.close();
	}
}
