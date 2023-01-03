package com.udemy.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.model.Course;
import com.udemy.spring.model.Instructor;
import com.udemy.spring.model.InstructorDetail;
import com.udemy.spring.model.Review;
import com.udemy.spring.model.Student;

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
		//app.createCourse();
		//app.addCoursesToStudent();
		//app.getStudentCourses();
		//app.deteleCourse();
		app.deleteStudent();
	}
	
	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public void createCourse() {
		System.out.println("create course");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Course course = new Course();
		course.setTitle("Many to Many");
		
		System.out.println("saving course");
		session.save(course);
		
		System.out.println(course);
		
		Student student1 = new Student();
		student1.setEmail("student1@mail.com");
		student1.setFirstName("first");
		student1.setLastName("last");
		
		Student student2 = new Student();
		student2.setEmail("student2@mail.com");
		student2.setFirstName("first");
		student2.setLastName("last");
		
		course.addStudent(student1);
		course.addStudent(student2);
		
		System.out.println("saving courses");
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
	}
	
	public void addCoursesToStudent() {
		System.out.println("addCoursesToStudent");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student student = session.get(Student.class, 29l);
		
		if(student != null) {
			System.out.println(student);
			
			if(student.getCourses() != null && !student.getCourses().isEmpty()) {
				for(Course obj : student.getCourses()) {
					System.out.println(obj);
				}
			}
		}
		
		Course course = new Course();
		course.setTitle("one to one");
		
		Course course2 = new Course();
		course2.setTitle("many to one");
		
		student.addCourse(course);
		student.addCourse(course2);
		
		System.out.println("saving courses");
		session.save(course);
		session.save(course2);
		
		session.getTransaction().commit();
	}
	
	public void getStudentCourses() {
		System.out.println("getStudentCourses");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student student = session.get(Student.class, 29l);
		
		if(student != null) {
			System.out.println(student);
			
			if(student.getCourses() != null && !student.getCourses().isEmpty()) {
				System.out.println(student.getCourses());
			}
		}
		
		session.getTransaction().commit();
	}
	
	public void deteleCourse() {
		System.out.println("deteleCourse");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Course course = session.get(Course.class, 27l);
		if(course != null) {
			System.out.println(course);
		}
		
		System.out.println("deleting course");
		session.delete(course);
		
		session.getTransaction().commit();
	}
	
	public void deleteStudent() {
		System.out.println("deteleStudent");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student student = session.get(Student.class, 29l);
		
		if(student != null) {
			System.out.println(student);
			System.out.println(student.getCourses());
		}
		
		System.out.println("deleting student");
		session.delete(student);
		
		session.getTransaction().commit();
	}
}
