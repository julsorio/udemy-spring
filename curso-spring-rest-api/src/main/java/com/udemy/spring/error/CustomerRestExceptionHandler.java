package com.udemy.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(CustomerNotFoundException cnfe) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),
				cnfe.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}
}
