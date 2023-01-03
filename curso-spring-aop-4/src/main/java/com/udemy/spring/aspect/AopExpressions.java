package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(* com.udemy.spring.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.udemy.spring.dao.*.get*(..))")
	public void forGetter() {}
	
	@Pointcut("execution(* com.udemy.spring.dao.*.set*(..))")
	public void forSetter() {}
	
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void forDaoPackageNoGetterNoSetter() {}
}
