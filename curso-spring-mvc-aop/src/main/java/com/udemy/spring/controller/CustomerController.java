package com.udemy.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.spring.model.Customer;
import com.udemy.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// @RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model) {
		System.out.println("listCustomers");

		model.addAttribute("customersList", customerService.customersList());

		return "customersList";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		System.out.println("showFormForAdd");

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "addCustomer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		System.out.println("***" + customer + "***");

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(Model model, @RequestParam("customerId") Long customerId) {
		
		System.out.println("***" + customerId + "***");

		Customer customer = customerService.getCustomerById(customerId);
		
		System.out.println("***" + customer + "***");

		model.addAttribute("customer", customer);

		return "editCustomer";
	}
	
	@PostMapping("/editCustomer")
	public String editCustomer(@ModelAttribute("customer") Customer customer) {
		
		System.out.println("***" + customer + "***");
		
		customerService.updateCustomer(customer);
		
		return "redirect:/customer/list"; 
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Long customerId) {
		System.out.println("***" + customerId + "***");

		Customer customer = customerService.getCustomerById(customerId);
		
		System.out.println("***" + customer + "***");
		
		customerService.deleteCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String findCustomer(@RequestParam("search") String search, Model model) {
		System.out.println("***" + search + "***");
		
		model.addAttribute("customersList", customerService.findCustomerByNameOrLastName(search));
		
		return "customersList";
	}
}
