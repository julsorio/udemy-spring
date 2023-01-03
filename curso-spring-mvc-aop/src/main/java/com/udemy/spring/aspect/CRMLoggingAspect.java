package com.udemy.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	@Pointcut("execution(* com.udemy.spring.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.udemy.spring.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.udemy.spring.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {
		 System.out.println(this.getClass().getName() + " before method");
		 
		 String method = joinPoint.getSignature().toShortString();
		 System.out.println("Calling method: " + method);
		 
		 System.out.println("method arguments");
		 Object[] args = joinPoint.getArgs();
		 for(Object arg : args) {
			 System.out.println("arg: " + arg);
		 }
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	private void afterReturning(JoinPoint joinPoint, Object result) {
		System.out.println(this.getClass().getName() + " afterReturning method");
		 
		 String method = joinPoint.getSignature().toShortString();
		 System.out.println("Calling method: " + method);
		 
		 System.out.println("result: " + result);

	}
}
