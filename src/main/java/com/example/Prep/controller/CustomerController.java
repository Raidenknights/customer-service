package com.example.Prep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prep.constants.Constants;
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
		this.customerService = customerService;
	}

	@GetMapping(path = Constants.FETCH_CUSTOMER_DETAIL_URL)
	public ResponseEntity<Customer> fetchCustomerByUserName(Authentication auth) {

		return new ResponseEntity<>(customerService.readCustomer(auth.getName()), HttpStatus.OK);

	}

	@PostMapping(path = Constants.CREATE_CUSTOMER_URL)
	public ResponseEntity<String> createUser(@RequestBody Customer customer) {

		customerService.addCustomer(customer);
		return new ResponseEntity<>("User has been created", HttpStatus.CREATED);
	}

}
