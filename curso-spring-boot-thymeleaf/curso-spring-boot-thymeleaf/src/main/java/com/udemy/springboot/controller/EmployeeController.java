package com.udemy.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springboot.dto.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employeesList;

	@PostConstruct
	public void init() {
		employeesList = new ArrayList<>();

		Employee emp1 = new Employee("Mario", "Gonzales", "mariogonzales@gmail.com");
		Employee emp2 = new Employee("Felipe", "Parra", "felipeparra@gmail.com");
		Employee emp3 = new Employee("Pablo", "Guzman", "pabloguzman@gmail.com");
		Employee emp4 = new Employee("Juan", "Martinez", "juanmartinez@gmail.com");
		Employee emp5 = new Employee("Luis", "Villalba", "luisvillalba@gmail.com");
		Employee emp6 = new Employee("Eduardo", "Pelaez", "eduardopelaez@gmail.com");
		
		employeesList.add(emp1);
		employeesList.add(emp2);
		employeesList.add(emp3);
		employeesList.add(emp4);
		employeesList.add(emp5);
		employeesList.add(emp6);
	}

	@GetMapping("/")
	public String getEmployeesList(Model model) {
		
		model.addAttribute("employeesList", employeesList);

		return "employee-list";
	}
}

