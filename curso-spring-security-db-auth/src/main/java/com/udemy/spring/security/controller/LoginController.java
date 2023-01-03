package com.udemy.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/loginPage")
	public String loginPage() {
		System.out.println("*** login page ***");
		
		return "fancy-login";
	}
	
	@RequestMapping("/access-denied")
	public String showAccessDenied() {
		System.out.println("*** access denied ***");
		
		return "accessDenied";
	}
}
