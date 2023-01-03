package org.app.test;

import org.app.test.model.Instructor2;
import org.app.test.model.InstructorDetail2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App2 {
	SessionFactory factory;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App2 app = new App2();
		app.init();
		app.test();
		app.test1();
		app.test2();
	}

	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor2.class)
				.addAnnotatedClass(InstructorDetail2.class).buildSessionFactory();
	}

	public void test() {
		System.out.println("test");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Instructor2 instructor = new Instructor2();
		instructor.setEmail("instructor@gmail.com");
		instructor.setFirstName("Jhon");

		InstructorDetail2 instructorDetail = new InstructorDetail2();
		instructorDetail.setHobby("soccer");
		instructorDetail.setYoutubeChannel("www.youtube.com/test");

		instructor.setInstructorDetail(instructorDetail);
		instructor.setLastName("Connor");
		
		session.save(instructor);
		
		session.getTransaction().commit();

	}

	public void test1() {
		System.out.println("query instructor detail");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		InstructorDetail2 instructorDetail = session.get(InstructorDetail2.class, 1l);
		System.out.println(instructorDetail);
		
		System.out.println(instructorDetail.getInstructor());
		
	}
	
	public void test2() {
		System.out.println("delete instructor detail");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		InstructorDetail2 instructorDetail = session.get(InstructorDetail2.class, 1l);
		System.out.println(instructorDetail);
		
		if(instructorDetail != null) {
			session.delete(instructorDetail);
		}
		
		session.getTransaction().commit();
	}
}
