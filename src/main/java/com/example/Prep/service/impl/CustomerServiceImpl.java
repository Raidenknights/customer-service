package com.example.Prep.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.errorHandling.exceptions.EmaiAlreadyInUseException;
import com.example.Prep.errorHandling.exceptions.UsernameAlreadyExistsException;
import com.example.Prep.repository.CustomerRepository;
import com.example.Prep.service.CustomerService;

/**
 * This is the customer service implementation.
 * 
 * @author Manas Vishnoi
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	private final CustomerRepository customerRepository;

	private final PasswordEncoder passwordEncoder;

	// Constructor based dependency
	public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Add a new customer to customer database.
	 * 
	 * @param customer (request received during the API call).
	 */
	@Override
	public void addCustomer(Customer customer) {
		logger.debug("Entered add customer method with customer details");
		checkIfCustomerExist(customer.getUsername(), customer.getEmail());
		CustomerEntity customerEntity = mapToEntity(customer);
		customerRepository.save(customerEntity);
	}

	@Override
	public void deleteCustomer(String customerId) {

	}

	@Override
	public void modifyCustomer(String customerId, Customer customer) {

	}

	@Override
	public Customer readCustomer(String username) {
		CustomerEntity customerEntity = customerRepository.findByusername(username);

		return mapToCustomer(customerEntity);

	}

	@Override
	public boolean checkIfCustomerExists(String email) {
		CustomerEntity customerEntity = customerRepository.findByemail(email);
		if (customerEntity != null)
			return true;
		else
			return false;
	}

	/**
	 * Map entity returned from database to DTO object.
	 * 
	 * @param customerEntity (entity object)
	 * @return Customer (DTO object)
	 */
	private Customer mapToCustomer(CustomerEntity customerEntity) {

		Customer customer = new Customer();

		customer.setCustomerId(customerEntity.getCustomerId().toString());
		customer.setUsername(customerEntity.getUsername());
		customer.setEmail(customerEntity.getEmail());
		customer.setEnabled(customerEntity.isEnabled());

		return customer;

	}

	/**
	 * This is a mapper method which converts DTO to entity class object which is
	 * used to communicate with database.
	 * 
	 * @param customer (DTO object received from request)
	 * @return CustomerEntity
	 */
	private CustomerEntity mapToEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();

		if (customer != null) {

			long currentTime = System.currentTimeMillis();
			Date dateOfRegistration = new Date(currentTime);

			customerEntity.setEnabled(true);
			customerEntity.setUsername(customer.getUsername());
			customerEntity.setPassword(passwordEncoder.encode(customer.getPassword()));
			customerEntity.setEmail(customer.getEmail());
			customerEntity.setRegistrationDate(dateOfRegistration);
			customerEntity.setRole("customer");
		}

		return customerEntity;
	}

	/**
	 * This method check if an user exist with the same user-name and email. If it
	 * already exists this method will throw respective errors.
	 * 
	 * @param username (username of the customer)
	 * @param email    (email of the customer)
	 * @return boolean
	 */
	private boolean checkIfCustomerExist(String username, String email) {

		CustomerEntity customerEntityByUserName = customerRepository.findByusername(username);

		if (customerEntityByUserName != null) {
			throw new UsernameAlreadyExistsException(
					"UserName:" + username + " already exists. Please choose another user name");
		}

		CustomerEntity customerEntityByEmail = customerRepository.findByemail(username);

		if (customerEntityByEmail != null) {
			throw new EmaiAlreadyInUseException("Email:" + email + " already in use by another user");
		}

		return true;

	}
}
