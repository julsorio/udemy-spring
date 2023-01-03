package com.udemy.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.spring.error.StudentErrorResponse;

@ControllerAdvice
public class StudentExceptionHandler {
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
