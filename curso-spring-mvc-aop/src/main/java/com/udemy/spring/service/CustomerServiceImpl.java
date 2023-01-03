package com.udemy.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.spring.dao.CustomerDAO;
import com.udemy.spring.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> customersList() {
		return customerDAO.customersList();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(Long customerId) {
		Customer customer = customerDAO.getCustomerById(customerId);
		
		return customer;
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> findCustomerByNameOrLastName(String search) {
		return customerDAO.findCustomerByNameOrLastName(search);
	}
	
}
