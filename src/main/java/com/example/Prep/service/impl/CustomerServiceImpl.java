package com.example.Prep.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public void addCustomer(Customer customer) {
		System.out.println(customer);
		// TODO Auto-generated method stub
		
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
	public Customer readCustomer(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private CustomerEntity mapToEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		
		Optional.ofNullable(customer).ifPresent(cus->{
			if(cus!=null) {

			}
		});
		return null;
	}
}
