package com.udemy.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.udemy.spring.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		System.out.println("afterThrowingFindAccountsAdvice");

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		
		System.out.println("Exception " + exception);

		
	}

}
