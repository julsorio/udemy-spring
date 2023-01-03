package com.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String showLanding() {
		System.out.println("*** landing ***");

		return "landing";
	}

	@GetMapping("/employees")
	public String showHome() {
		System.out.println("*** home ***");

		return "home";
	}
}
