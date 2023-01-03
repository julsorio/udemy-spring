package com.udemy.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.model.Student;

public class CreateStudentApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			System.out.println("student instance");
			Student student = new Student();
			student.setEmail("student.email@mail.com");
			student.setFirstName("Jhon");
			student.setLastName("Connor");
			
			System.out.println("begin transaction");
			session.beginTransaction();
			System.out.println("saving student");
			session.save(student);
			System.out.println("commiting");
			session.getTransaction().commit();
			
			System.out.println("student id: " + student.getId());
			
			System.out.println("retrieving the object");
			System.out.println("begin transaction");
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student dbStudent = session.get(Student.class, student.getId());
			System.out.println(dbStudent);
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			factory.close();
		}
	}

}
