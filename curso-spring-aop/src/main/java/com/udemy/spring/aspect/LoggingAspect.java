package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	//@Before(value = "execution(public void addAccount())")
	//@Before(value = "execution(public void com.udemy.spring.aop.dao.AccountDAO.addAccount())")
	//@Before(value = "execution(public void add*())")
	//@Before(value = "execution(* add*())")
	//@Before(value = "execution(* add*(com.udemy.spring.aop.dao.Account, ..))")
	//@Before(value = "execution(* add*(..))")
	@Before(value = "execution(* com.udemy.spring.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("beforeAddAccountAdvice()");
	}
}
