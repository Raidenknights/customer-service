package com.example.Prep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.service.CustomerService;

/*
 * This class is only for CRUD API for the customer
 */
@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
		this.customerService=customerService;
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		
		return new ResponseEntity<>("Customer access", HttpStatus.CREATED);
	}

}
