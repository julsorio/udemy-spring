package com.udemy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.spring.error.StudentErrorResponse;
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

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(snfe.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
