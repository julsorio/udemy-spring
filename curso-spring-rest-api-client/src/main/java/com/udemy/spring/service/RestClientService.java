package com.udemy.spring.service;

import java.util.List;

import com.udemy.spring.dto.Customer;

public interface RestClientService {
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(Long customerId);
	
	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Long customerId);
}
