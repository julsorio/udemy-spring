package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticAspect {

	@Before(value = "com.udemy.spring.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
	public void performApiAnalytics() {
		System.out.println("perform api analytics");
	}
}
