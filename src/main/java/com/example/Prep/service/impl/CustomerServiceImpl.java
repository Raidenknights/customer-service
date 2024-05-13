package com.example.Prep.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.repository.CustomerRepository;
import com.example.Prep.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void addCustomer(Customer customer) {
		System.out.println(customer);
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = mapToEntity(customer);
		customerRepository.save(customerEntity);

	}

	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyCustomer(String customerId, Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer readCustomer(String username) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = customerRepository.findByusername(username);
		Customer customer = mapToCustomer(customerEntity);

		return customer;

	}

	private Customer mapToCustomer(CustomerEntity customerEntity) {

		Customer customer = new Customer();

		customer.setCustomerId(customerEntity.getCustomerId());
		customer.setUsername(customerEntity.getUsername());
		customer.setEmail(customerEntity.getEmail());
		customer.setEnabled(customerEntity.isEnabled());

		return customer;

	}

	private CustomerEntity mapToEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();

		if (customerEntity != null) {

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
}
