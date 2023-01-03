package com.udemy.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.udemy.spring.dao.Account;

@Aspect
@Component
public class LoggingAspect {
	
	@Before(value = "execution(* com.udemy.spring.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("beforeAddAccountAdvice()");
	}
	
	@Before(value = "execution(* com.udemy.spring.dao.AccountDAO.addAccount(..))")
	public void beforeAddAccountAdvice2(JoinPoint joinPoint) {
		System.out.println("beforeAddAccountAdvice join point");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); 
		System.out.println("method signature: " + methodSignature);
		
		Object[] arguments = joinPoint.getArgs();
		for(Object args : arguments) {
			System.out.println(args);
			
			if(args instanceof Account) {
				Account account = (Account) args;
				
				System.out.println(account.getLevel() + " " + account.getName());
			}
		}
	}
}
