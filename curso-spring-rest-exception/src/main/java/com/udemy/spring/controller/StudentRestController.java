package com.udemy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.spring.exceptions.StudentNotFoundException;
import com.udemy.spring.pojo.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void init() {
		students = new ArrayList<Student>();

		students.add(new Student("Juan", "Barrera"));
		students.add(new Student("Gonzalo", "Galvan"));
		students.add(new Student("Juan", "Pachon"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		Student student = null;

		if (studentId < 0 || studentId >= students.size()) {
			throw new StudentNotFoundException("Student not found - " + studentId);
		}

		student = students.get(studentId);

		return student;
	}

	
}
