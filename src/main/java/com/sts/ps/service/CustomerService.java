package com.sts.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.ps.entity.Customer;
import com.sts.ps.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	//Retrieves all customers from the database by invoking the findAll() method provided by Spring Data JPA
	public Iterable<Customer> getAllCustomers() {
        return customerRepo.findAll();      
    }

	//Retrieves a customer by ID using the findById() method provided by Spring Data JPA.
    public Customer getCustomerById(Integer customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    // Saves a customer to the database using the save() method provided by Spring Data JPA. If the customer already exists, it updates the existing record; otherwise, it creates a new one.
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
}
