package com.udemy.spring;

import java.util.List;

import org.app.test.model.Course;
import org.app.test.model.Instructor;
import org.app.test.model.InstructorDetail;
import org.app.test.model.Review;
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
		App app = new App();
		app.init();
		app.createReviews();
		app.getCourseReviews();
		app.deleteCourseReviews();
	}

	public void init() {
		System.out.println("init");
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
	}

	public void createReviews() {
		System.out.println("create reviews");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Course course = session.get(Course.class, 11l);

		if (course != null) {
			System.out.println(course);
		}

		Review review1 = new Review();
		review1.setComment("first review");

		Review review2 = new Review();
		review2.setComment("second review");

		Review review3 = new Review();
		review3.setComment("third review");

		course.addReview(review1);
		course.addReview(review2);
		course.addReview(review3);

		session.save(course);

		session.getTransaction().commit();
	}

	public void getCourseReviews() {
		System.out.println("get course and reviews");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Course course = session.get(Course.class, 11l);

		if (course != null) {
			System.out.println(course);
		}

		List<Review> reviews = course.getReviews();
		if (reviews != null && !reviews.isEmpty()) {
			for (Review obj : reviews) {
				System.out.println(obj);
			}
		}

		session.getTransaction().commit();
	}

	public void deleteCourseReviews() {
		System.out.println("delete course and reviews");
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Course course = session.get(Course.class, 11l);

		if (course != null) {
			System.out.println(course);
		}

		session.delete(course);

		session.getTransaction().commit();
	}
}
