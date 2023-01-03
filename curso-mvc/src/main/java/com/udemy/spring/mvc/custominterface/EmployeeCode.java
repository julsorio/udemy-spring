package com.udemy.spring.mvc.custominterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.udemy.spring.mvc.validator.EmployeeCodeValidator;

@Constraint(validatedBy = EmployeeCodeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeCode {
	
	public String value() default "COL";
	
	public String message() default "must start with COL";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};

}
