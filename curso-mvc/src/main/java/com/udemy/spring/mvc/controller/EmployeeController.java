package com.udemy.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.spring.mvc.dto.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeRegistration";
	}

	@RequestMapping("/processRegistration")
	public String processRegistration(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "employeeRegistration";
		}
		else {
			return "registrationConfirmation";
		}
		
		
	}
}
