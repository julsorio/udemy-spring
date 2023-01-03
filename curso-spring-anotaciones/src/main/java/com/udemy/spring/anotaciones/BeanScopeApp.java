package com.udemy.spring.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.anotaciones.coach.Coach;

public class BeanScopeApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("swimCoach", Coach.class);
		Coach myCoach2 = context.getBean("swimCoach", Coach.class);
		
		System.out.println("mycoach and mycoach2 pointing to the same object " + (myCoach == myCoach2));
		System.out.println("location for myCoach: " + myCoach);
		System.out.println("location for myCoach2: " + myCoach2);
		
		Coach myCoach3 = context.getBean("boxingCoach", Coach.class);
		Coach myCoach4 = context.getBean("boxingCoach", Coach.class);
		
		System.out.println("mycoach3 and mycoach4 pointing to the same object " + (myCoach3 == myCoach4));
		System.out.println("location for myCoach3: " + myCoach3);
		System.out.println("location for myCoach4: " + myCoach4);
		
		context.close();
	}

}
