package com.example.Prep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prep.constants.Constants;
import com.example.Prep.dto.request.Customer;
import com.example.Prep.service.CustomerService;

/*
 * This class the controller class and exposes API to perform Create and fetch operations for customer.
 * @author: Manas Vishnoi
 */
@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;

	// constructor based dependency
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(path = Constants.FETCH_CUSTOMER_DETAIL_URL)
	public ResponseEntity<Customer> fetchCustomerByUserName(Authentication auth) {

		logger.debug("Entered fetchCustomerByUserName method");
		return new ResponseEntity<>(customerService.readCustomer(auth.getName()), HttpStatus.OK);

	}

	@GetMapping(path = Constants.CHECK_IF_CUSTOMER_EXISTS)
	public ResponseEntity<Boolean> checkIfCustomerExists(@PathVariable String email) {

		logger.debug("Entered checkIfCustomerExists method");
		return new ResponseEntity<>(customerService.checkIfCustomerExists(email), HttpStatus.OK);
	}

	@PostMapping(path = Constants.CREATE_CUSTOMER_URL)
	public ResponseEntity<String> createUser(@RequestBody Customer customer) {

		logger.debug("Entered createUser method");
		customerService.addCustomer(customer);
		return new ResponseEntity<>("User has been created", HttpStatus.CREATED);
	}

}
