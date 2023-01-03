package com.udemy.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.springboot.crud.model.Employee;
import com.udemy.springboot.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}
	
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}
