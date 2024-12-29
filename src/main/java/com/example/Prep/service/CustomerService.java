package com.example.Prep.service;

import com.example.Prep.dto.request.Customer;

/**
 * This is an interface created as a service layer for Customer controller.
 * It's methods are implemented in implementation class.
 * @author: Manas Vishnoi
 **/
public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public void deleteCustomer(String customerId);
	public void modifyCustomer(String customerId, Customer customer);
	public Customer readCustomer(String username);
	public boolean checkIfCustomerExists(String email);

}
