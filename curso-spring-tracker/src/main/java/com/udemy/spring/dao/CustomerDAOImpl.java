package com.udemy.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.spring.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> customersList() {
		System.out.println("customersList()");

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Customer order by lastName");

		return query.list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public List<Customer> findCustomerByNameOrLastName(String search) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		List<Customer> customerList = null;
		
		if(search != null && search.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :search or lower(lastName) like :search");
			query.setParameter("search", "%"+search+"%");
			customerList = query.list();
		}
		else {
			query = session.createQuery("from Customer order by lastName");
			customerList = query.list();
		}
		
		return customerList;
	}
	
	

}
