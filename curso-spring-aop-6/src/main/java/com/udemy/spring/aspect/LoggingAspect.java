package com.udemy.spring.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.udemy.spring.dao.Account;

@Aspect
@Component
public class LoggingAspect {
	
	@AfterReturning(pointcut = "execution(* com.udemy.spring.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("afterReturningFindAccountsAdvice");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		
		System.out.println("result " + result);
		
		convertNamesToUpperCase(result);
		
		System.out.println("result uppercase " + result);
	}

	private void convertNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account account : result) {
			String accountName = account.getName().toUpperCase();
			
			account.setName(accountName);
		}
	}
}
