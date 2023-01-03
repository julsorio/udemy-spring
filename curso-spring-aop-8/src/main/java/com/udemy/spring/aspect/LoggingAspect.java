package com.udemy.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@After(value = "execution(* com.udemy.spring.dao.AccountDAO.findAccounts(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("after");

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
	}

}
