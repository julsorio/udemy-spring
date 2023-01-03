package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.coach.Coach;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //BaseballCoach baseballCoach = new BaseballCoach();
        //System.out.println(baseballCoach.getDailyWorkout());
        
        //Coach theCoach = new TrackCoach();
        //System.out.println(theCoach.getDailyWorkout());
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Coach theCoach = context.getBean("myCoach", Coach.class);
    	System.out.println(theCoach.getDailyWorkout());
    	
    	context.close();
    }
}
