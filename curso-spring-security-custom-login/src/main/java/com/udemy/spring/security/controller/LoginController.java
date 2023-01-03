package com.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/loginPage")
	public String loginPage() {
		System.out.println("*** login page ***");
		
		return "login";
	}
}
