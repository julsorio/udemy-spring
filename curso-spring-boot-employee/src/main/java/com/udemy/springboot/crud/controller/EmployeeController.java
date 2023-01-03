package com.udemy.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot.crud.model.Employee;
import com.udemy.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);

		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);

		return employee;
	}

	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);

		return "Deleted employee id: " + employee.getId();
	}
}
