package com.udemy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.spring.config.AppConfig;
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
		accountDAO.addAccount();
		accountDAO.getName();
		accountDAO.getServiceCode();
		accountDAO.setName("name");
		accountDAO.setServiceCode("service");
		
		context.close();
	}
}
