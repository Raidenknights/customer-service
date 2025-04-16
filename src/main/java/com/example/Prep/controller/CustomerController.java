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

/**
 * This class the controller class and exposes API to perform Create and fetch
 * operations for customer.
 * 
 * @author: Manas Vishnoi
 **/
@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;

	// constructor based dependency
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * This method fetches customer details from customer database. This API has
	 * authenticated enabled in security configuration.
	 * 
	 * @param auth
	 * @return ResponeEntity<Customer>
	 */
	@GetMapping(path = Constants.FETCH_CUSTOMER_DETAIL_URL)
	public ResponseEntity<Customer> fetchCustomerByUserName(Authentication auth) {

		logger.debug("Entered fetchCustomerByUserName method");
		return new ResponseEntity<>(customerService.readCustomer(auth.getName()), HttpStatus.OK);

	}

	/**
	 * This method checks if customer exists, we will check this using customer
	 * email.
	 * 
	 * @param email (email of the customer)
	 * @return ResponseEntity<Boolean>
	 */
	@GetMapping(path = Constants.CHECK_IF_CUSTOMER_EXISTS)
	public ResponseEntity<Boolean> checkIfCustomerExists(@PathVariable String email) {

		logger.debug("Entered checkIfCustomerExists method");
		return new ResponseEntity<>(customerService.checkIfCustomerExists(email), HttpStatus.OK);
	}

	/**
	 * This method will create a new customer in the table.
	 * 
	 * @param customer (Customer body for first time user registration).
	 * @return ResponseEntity<String>
	 */
	@PostMapping(path = Constants.CREATE_CUSTOMER_URL)
	public ResponseEntity<String> createUser(@RequestBody Customer customer) {

		logger.debug("Entered createUser method");
		customerService.addCustomer(customer);
		return new ResponseEntity<>("User has been created", HttpStatus.CREATED);
	}

	/**
	 * This method will modify existing customer in the database.
	 * 
	 * @param customerId
	 * @param customer
	 * @return ResponseEntity<String>
	 */
	public ResponseEntity<String> updateExistingUser(String customerId, @RequestBody Customer customer) {

		logger.debug("Entering update user method in Controller class");
		customerService.modifyCustomer(customerId, customer);

		return new ResponseEntity<>("Successfully modified details for customer id:" + customerId,
				HttpStatus.NO_CONTENT);

	}
}
