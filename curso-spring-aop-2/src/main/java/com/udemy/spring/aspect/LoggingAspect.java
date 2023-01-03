package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.udemy.spring.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before(value = "forDaoPackage()")
	public void beforeAddAcountAdvice() {
		System.out.println("executing @Before advice on method");
	}
	
	//@Before(value = "forDaoPackage()")
	public void apiAnalytics() {
		System.out.println("executing api analytics");
	}
}
