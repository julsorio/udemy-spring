package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

	@Before(value = "com.udemy.spring.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("@Before advice on method");
	}

}
