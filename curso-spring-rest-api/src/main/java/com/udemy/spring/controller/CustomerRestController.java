package com.udemy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.spring.error.CustomerNotFoundException;
import com.udemy.spring.model.Customer;
import com.udemy.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customersList = customerService.customersList();

		return customersList;
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("customer id not found");
		}

		return customer;
	}

	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}

	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("customer id not found");
		}
		
		customerService.deleteCustomer(customer);
	}
}
