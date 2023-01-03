package com.udemy.spring.dao;

import java.util.List;

import com.udemy.spring.model.Customer;

public interface CustomerDAO {
	public List<Customer> customersList();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomerById(Long customerId);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public List<Customer> findCustomerByNameOrLastName(String search);
	
}
