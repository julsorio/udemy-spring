package com.udemy.spring;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.model.Student;

public class GetStudentsApp {

	SessionFactory factory;

	public static void main(String[] args) {
		GetStudentsApp app = new GetStudentsApp();

		app.init();

	}

	public void init() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			System.out.println("saving students");
			saveStudents(factory);

			System.out.println("retrieving students");
			getStudentsFromDb(factory);
			
			System.out.println("query students");
			queryStudentsFromDb(factory);
			
			System.out.println("another query");
			queryStudentsFromDb2(factory);
			
			System.out.println("updating a student");
			updateStudent(factory);
			
			System.out.println("updating all students");
			updateAllStudents(factory);
			
			System.out.println("delete a student");
			deleteStudent(factory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close();
		}
	}

	public void saveStudents(SessionFactory factory) throws Exception {
		try {
			Session session = factory.getCurrentSession();

			List<Student> studentList = new ArrayList<>();

			Student student1 = new Student();
			student1.setEmail("student.email@mail.com");
			student1.setFirstName("Jhon");
			student1.setLastName("Connor");

			studentList.add(student1);

			Student student2 = new Student();
			student2.setEmail("student.email@mail.com");
			student2.setFirstName("Michael");
			student2.setLastName("Jordan");

			studentList.add(student2);

			Student student3 = new Student();
			student3.setEmail("student.email@mail.com");
			student3.setFirstName("Scottie");
			student3.setLastName("Pippen");

			studentList.add(student3);

			Student student4 = new Student();
			student4.setEmail("student.email@mail.com");
			student4.setFirstName("Dennis");
			student4.setLastName("Rodman");

			studentList.add(student4);

			System.out.println("begin transaction");
			session.beginTransaction();
			System.out.println("saving students");

			for (Student obj : studentList) {
				session.save(obj);
			}

			System.out.println("commiting");
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Error " + e.getMessage());
		}

	}

	public void getStudentsFromDb(SessionFactory factory) throws Exception {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			List<Student> studentList = session.createQuery("from Student").list();

			for (Student obj : studentList) {
				System.out.println("student: " + obj);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
	
	public void queryStudentsFromDb(SessionFactory factory) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> studentList = session.createQuery("from Student s where s.lastName='Rodman'").list();
			
			for(Student obj : studentList) {
				System.out.println("student: " + obj);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void queryStudentsFromDb2(SessionFactory factory) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> studentList = session.createQuery("from Student s where s.lastName='Rodman' or s.firstName='Jhon'").list();
			
			for(Student obj : studentList) {
				System.out.println("student: " + obj);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void updateStudent(SessionFactory factory) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student1 = new Student();
			student1.setEmail("student.email@gmail.com");
			student1.setFirstName("Peter");
			student1.setLastName("Sagan");
			
			session.save(student1);
			System.out.println("commiting");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("query the new student");
			Student theStudent = session.get(Student.class, student1.getId());
			System.out.println("new student: " + theStudent);
			
			theStudent.setFirstName("Peter Quill");
			session.update(theStudent);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("all the students");
			List<Student> list = session.createQuery("from Student").list();
			for(Student obj : list) {
				System.out.println(obj);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void updateAllStudents(SessionFactory factory) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.email='test@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").list();
			
			for(Student obj : students) {
				System.out.println(obj);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void deleteStudent(SessionFactory factory) {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = new Student();
			student.setEmail("test@gmail.com");
			student.setFirstName("delete");
			student.setLastName("me");
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Student to delete: " + student);
			Long studentId = student.getId();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").list();
			for(Student obj : students) {
				System.out.println(obj);
			}
			
			System.out.println("delete the student");
			student = null;
			session = factory.getCurrentSession();
			session.beginTransaction();
			student = session.get(Student.class, studentId);
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.delete(student);
			
			//session.createQuery("delete from Student s where s.id="+id);
			
			students = session.createQuery("from Student").list();
			for(Student obj : students) {
				System.out.println(obj);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
