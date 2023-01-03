package com.udemy.spring.service;

import java.util.List;

import com.udemy.spring.model.Customer;

public interface CustomerService {
	public List<Customer> customersList();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomerById(Long customerId);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public List<Customer> findCustomerByNameOrLastName(String search);
}
