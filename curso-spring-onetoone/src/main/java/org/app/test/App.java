package org.app.test;

import java.util.List;

import org.app.test.model.Instructor;
import org.app.test.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	SessionFactory factory;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		app.init();
		app.test();
		app.test1();
		app.test2();
		app.test1();
	}

	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	}

	public void test() {
		System.out.println("test");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Instructor instructor = new Instructor();
		instructor.setEmail("instructor@gmail.com");
		instructor.setFirstName("Jhon");

		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setHobby("soccer");
		instructorDetail.setYoutubeChannel("www.youtube.com/test");

		instructor.setInstructorDetail(instructorDetail);
		instructor.setLastName("Connor");
		
		Instructor instructor2 = new Instructor();
		instructor2.setEmail("instructor2@gmail.com");
		instructor2.setFirstName("Billy");

		InstructorDetail instructorDetail2 = new InstructorDetail();
		instructorDetail2.setHobby("music");
		instructorDetail2.setYoutubeChannel("www.youtube.com/test2");

		instructor2.setInstructorDetail(instructorDetail2);
		instructor2.setLastName("Idol");

		session.save(instructor2);

		session.getTransaction().commit();

	}

	public void test1() {
		System.out.println("query instructor");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Instructor> instructorList = session.createQuery("from Instructor").list();
		
		if(instructorList != null && !instructorList.isEmpty()) {
			for(Instructor obj : instructorList) {
				System.out.println(obj);
			}
		}
		

		List<InstructorDetail> instructorDetailList = session.createQuery("from InstructorDetail").list();

		if (instructorDetailList != null && !instructorDetailList.isEmpty()) {
			for (InstructorDetail obj : instructorDetailList) {
				System.out.println(obj);
			}
		}
	}
	
	public void test2() {
		System.out.println("delete instructor");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1l);
		System.out.println(instructor);
		
		if(instructor != null) {
			session.delete(instructor);
		}
		
		session.getTransaction().commit();
	}
}
