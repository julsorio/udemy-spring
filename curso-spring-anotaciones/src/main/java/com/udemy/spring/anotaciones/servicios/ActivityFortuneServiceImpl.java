package com.udemy.spring.anotaciones.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ActivityFortuneServiceImpl implements ActivityFortuneService {
	private String[] randomFortunes;

	@PostConstruct
	public void readFortunes() {
		System.out.println("leyendo fortunes");
		randomFortunes = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("fortunes.txt")));
			String line = null;
			String text = null;
			while((line = br.readLine()) != null) {
				text = line;
			}
			
			if(text != null) {
				randomFortunes = text.split(",");
			}
			
		} catch (Exception e) {
			System.out.println("Error al leer archivo: " + e.getMessage());
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error cerrando buffered reader: " + e.getMessage());
			}
		}
	}
	
	public String getFortune() {
		Random random = new Random();
		int pos = random.nextInt(randomFortunes.length);
		
		return randomFortunes[pos];
	}
}
