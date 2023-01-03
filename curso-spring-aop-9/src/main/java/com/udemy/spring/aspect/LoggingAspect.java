package com.udemy.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

	@Around(value = "execution(* com.udemy.spring.service.TrafficFortuneService.getFortune(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info("around");
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		long duration = end-begin;
		logger.info("duration: " + duration / 1000 + " seconds");

		return result;
	}
	
	@Around(value = "execution(* com.udemy.spring.service.TrafficFortuneService.getFortuneException(..))")
	public Object aroundException(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info("around exception");
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.warning(e.getMessage());
			
			result = "Major accident! AOP is on the way";
		}
		
		long end = System.currentTimeMillis();
		long duration = end-begin;
		logger.info("duration: " + duration / 1000 + " seconds");
		
		return result;
	}
	
	@Around(value = "execution(* com.udemy.spring.service.TrafficFortuneService.getFortuneException2(..))")
	public Object aroundException2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("around exception");
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.warning(e.getMessage());
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		long duration = end-begin;
		logger.info("duration: " + duration / 1000 + " seconds");
		
		return result;
	}

}
