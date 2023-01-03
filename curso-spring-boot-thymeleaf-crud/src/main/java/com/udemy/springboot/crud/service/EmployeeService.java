package com.udemy.springboot.crud.service;

import java.util.List;

import com.udemy.springboot.crud.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee getEmployeeById(Long employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Employee employee);
}
