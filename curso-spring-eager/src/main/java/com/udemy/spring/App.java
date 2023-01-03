package com.udemy.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.model.Course;
import com.udemy.spring.model.Instructor;
import com.udemy.spring.model.InstructorDetail;

/**
 * Hello world!
 *
 */
public class App {
	
	SessionFactory factory;
	
	public static void main(String[] args) {
		App app = new App();
		app.init();
		app.getInstructorAndCourses();
	}
	
	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
	}
	
	public void getInstructorAndCourses() {
		System.out.println("getInstructorAndCourses");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1l);
		
		if(instructor != null) { 
			System.out.println(instructor);
			
			System.out.println(instructor.getCourses());
		}
		
		session.getTransaction().commit();
	}
}
