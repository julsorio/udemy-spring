package com.udemy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udemy.spring.dto.Customer;
import com.udemy.spring.service.RestClientService;

@Controller
@RequestMapping("/client")
public class RestClientController {

	@Autowired
	private RestClientService restClientService;

	@GetMapping("/customers")
	public @ResponseBody List<Customer> getCustomers() {
		return restClientService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public @ResponseBody Customer getCustomerById(@PathVariable("customerId") Long customerId) {
		return restClientService.getCustomerById(customerId);
	}

	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		restClientService.createCustomer(customer);
	}

	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		restClientService.updateCustomer(customer);
	}

	@DeleteMapping("/customers")
	public void deleteCustomer(@PathVariable Long customerId) {
		restClientService.deleteCustomer(customerId);
	}
}
