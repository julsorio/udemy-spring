package com.udemy.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.spring.dto.Customer;

@Service
public class RestClientServiceImpl implements RestClientService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${crm.rest.url}")
	private String restServiceUrl;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public List<Customer> getCustomers() {
		logger.info("get customers rest api: " + restServiceUrl);

		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(restServiceUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});

		List<Customer> customersList = responseEntity.getBody();

		/*
		 * ResponseEntity<Customer[]> response =
		 * restTemplate.getForEntity(restServiceUrl, Customer[].class); Customer[]
		 * customers = response.getBody();
		 * 
		 * List<Customer> customersList = Arrays.asList(customers);
		 */

		return customersList;
	}
	
	@Override
	public Customer getCustomerById(Long customerId) {
		logger.info("get customer by id rest api: " + restServiceUrl);
		
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(restServiceUrl + "/" + customerId, Customer.class);
		Customer customer = responseEntity.getBody();
		
		return customer;
	}
	
	@Override
	public void createCustomer(Customer customer) {
		logger.info("create customer rest api: " + restServiceUrl);
		
		restTemplate.postForEntity(restServiceUrl, customer, String.class);
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		logger.info("update customer rest api: " + restServiceUrl);
		
		restTemplate.put(restServiceUrl, customer);
	}
	
	@Override
	public void deleteCustomer(Long customerId) {
		logger.info("delete customer rest api: " + restServiceUrl);
		
		restTemplate.delete(restServiceUrl + "/" + customerId);
	}
}
