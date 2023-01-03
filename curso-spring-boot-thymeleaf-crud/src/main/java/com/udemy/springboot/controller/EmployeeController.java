package com.udemy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springboot.crud.model.Employee;
import com.udemy.springboot.crud.service.EmployeeService;

@Controller
@RequestMapping("/crud")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		List<Employee> employeesList = employeeService.getEmployees();
		
		model.addAttribute("employeesList", employeesList);
		
		return "employees";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/crud/list";
	}
	
	@GetMapping("/editEmployee/{employeeId}")
	public String editEmployee(Model model, @PathVariable("employeeId") Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		
		return "editEmployee";
	}
	
	@GetMapping("/deleteEmployee/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		employeeService.deleteEmployee(employee);
		
		return "redirect:/crud/list";
	}
}
