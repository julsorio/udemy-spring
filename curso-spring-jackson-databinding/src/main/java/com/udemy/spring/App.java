package com.udemy.spring;

import java.io.File;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.spring.demo.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		app.json();
	}

	public void json() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Student student = objectMapper.readValue(getFileFromResources("sample-full.json"), Student.class);

			System.out.println("the student: " + student);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File getFileFromResources(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}
}
