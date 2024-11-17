package com.example.Prep.service;

import com.example.Prep.dto.request.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public void deleteCustomer(String customerId);
	public void modifyCustomer(String customerId, Customer customer);
	public Customer readCustomer(String username);
	public boolean checkIfCustomerExists(String email);

}
