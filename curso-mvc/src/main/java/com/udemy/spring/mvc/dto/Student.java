package com.udemy.spring.mvc.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private String countryName;
	private Map<String, String> countryMap;
	private String vehicle;
	private String language;
	private Map<String, String> languageMap;
	private String[] operatingSystems;

	public Student() {
		countryMap = new HashMap<String, String>();
		countryMap.put("br", "Brasil");
		countryMap.put("fr", "France");
		countryMap.put("co", "Colombia");
		countryMap.put("es", "Spain");

		languageMap = new HashMap<String, String>();
		languageMap.put("Java", "Java");
		languageMap.put("Javascript", "Javascript");
		languageMap.put("Php", "Php");
		languageMap.put(".net", ".net");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public Map<String, String> getCountryMap() {
		return countryMap;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, String> getLanguageMap() {
		return languageMap;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", countryName=" + countryName
				+ ", countryMap=" + countryMap + ", vehicle=" + vehicle + ", language=" + language + ", languageMap="
				+ languageMap + ", operatingSystems=" + Arrays.toString(operatingSystems) + "]";
	}

}
