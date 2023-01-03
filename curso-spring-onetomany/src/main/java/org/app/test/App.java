package org.app.test;

import java.util.ArrayList;

import org.app.test.model.Course;
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
		//app.insertInstructorData();
		//app.createCourses();
		//app.getInstructorCourses();
		app.deleteCourse();
	}
	
	public void deleteCourse() {
		System.out.println("delete course");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Course course = session.get(Course.class, 12l);
		
		session.delete(course);
		
		session.getTransaction().commit();
	}

	public void getInstructorCourses() {
		System.out.println("instructor courses");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1l);
		if(instructor != null) {
			if(instructor.getCourses() != null && !instructor.getCourses().isEmpty()) {
				for(Course obj : instructor.getCourses()) {
					System.out.println(obj);
				}
			}
		}

		session.getTransaction().commit();
	}

	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
	}

	public void insertInstructorData() {
		System.out.println("insert instructor - instructor detail");
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

		session.save(instructor);

		session.getTransaction().commit();

	}

	public void createCourses() {
		System.out.println("create Courses");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Instructor instructor = session.get(Instructor.class, 1l);
		System.out.println(instructor);

		Course course = new Course();
		course.setTitle("how to program in java");

		Course course2 = new Course();
		course2.setTitle("spring boot first steps");
		
		instructor.setCourses(new ArrayList<Course>());
		instructor.getCourses().add(course);
		instructor.getCourses().add(course2);
	
		course.setInstructor(instructor);
		course2.setInstructor(instructor);
		
		session.save(course);
		session.save(course2);
		
		session.getTransaction().commit();
	}
	
}
