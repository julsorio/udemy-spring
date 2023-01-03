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
	
	@Pointcut("execution(* com.udemy.spring.dao.*.get*(..))")
	private void forGetter() {}
	
	@Pointcut("execution(* com.udemy.spring.dao.*.set*(..))")
	private void forSetter() {}
	
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	private void forDaoPackageNoGetterNoSetter() {}

	@Before(value = "forDaoPackageNoGetterNoSetter()")
	public void beforeAddAcountAdvice() {
		System.out.println("executing @Before advice on method");
	}
	
	@Before(value = "forDaoPackageNoGetterNoSetter()")
	public void apiAnalytics() {
		System.out.println("executing api analytics");
	}
	
}
