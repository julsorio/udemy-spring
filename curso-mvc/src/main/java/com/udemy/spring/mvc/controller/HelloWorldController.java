package com.udemy.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processForm2")
	public String processForm2(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		model.addAttribute("uppercase", name);
		
		return "helloworld";
	}
	
	@RequestMapping("/processForm3")
	public String processForm3(@RequestParam("studentName") String studentName, Model model) {
		
		studentName = studentName.toUpperCase();
		model.addAttribute("uppercase", "hola " + studentName);
		
		return "helloworld";
	}
}
