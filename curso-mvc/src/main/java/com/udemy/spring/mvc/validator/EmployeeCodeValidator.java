package com.udemy.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.udemy.spring.mvc.custominterface.EmployeeCode;

public class EmployeeCodeValidator implements ConstraintValidator<EmployeeCode, String> {
	private String employeePrefix;

	@Override
	public void initialize(EmployeeCode constraintAnnotation) {
		employeePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result;

		if (value != null) {
			result = value.startsWith(employeePrefix);
		} else {
			result = true;
		}

		return result;
	}

}
