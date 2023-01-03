package com.udemy.spring.anotaciones.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ArcheryCoach {

	@PostConstruct
	public void init() {
		System.out.println("metodo init postconstruct");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("metodo destroy predestroy");
	}
}
