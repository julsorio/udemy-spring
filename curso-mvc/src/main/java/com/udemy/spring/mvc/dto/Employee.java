package com.udemy.spring.mvc.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.udemy.spring.mvc.custominterface.EmployeeCode;

public class Employee {
	@NotNull(message = "first name required")
	private String firstName;
	@NotNull(message = "last name required")
	private String lastName;
	@NotNull(message = "age required")
	@Min(value = 18, message = "age must be greater than 18")
	@Max(value = 99, message = "age must be less than 100")
	private Integer age;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	@EmployeeCode
	private String employeeCode;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", postalCode="
				+ postalCode + ", employeeCode=" + employeeCode + "]";
	}

	

}
