/**
 * 
 */
package com.udemy.spring.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.spring.service.FortuneService;

/**
 * @author Julian
 *
 */
@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneServiceImpl")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "10 minutes smash practice";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
