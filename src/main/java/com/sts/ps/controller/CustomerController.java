package com.sts.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.ps.entity.Customer;
import com.sts.ps.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	 @Autowired
	    private CustomerService customerService;

//Handles HTTP GET requests to /customers, retrieves all customers, and returns them.
	    @GetMapping
	    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
	        Iterable<Customer> customers = customerService.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    }


//Handles HTTP GET requests to /customers/{customerId}, retrieves a customer by ID, and returns it.
	    @GetMapping("/{customerId}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) {
	        Customer customer = customerService.getCustomerById(customerId);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
// Handles HTTP POST requests to /customers, saves a new customer to the database, and returns the 
//saved customer object.
	    @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.saveCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }
}
