package com.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String showHome() {
		System.out.println("*** home ***");
		
		return "home";
	}
}
