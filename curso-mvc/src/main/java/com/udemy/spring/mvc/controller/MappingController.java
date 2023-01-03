package com.udemy.spring.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.spring.mvc.dto.Student;

@Controller
@RequestMapping("/register")
public class MappingController {
	
	@Value("#{vehicleOptions}")
	private Map<String, String> vehicleOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("vehicleOptions", vehicleOptions);
		model.addAttribute("student", new Student());
		return "register";
	}
	
	@RequestMapping("/processRegister")
	public String showConfirmation(@ModelAttribute("student") Student student) {
		System.out.println(student.toString());
		return "confirmation";
	}
	
}
