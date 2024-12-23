package com.example.Prep;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.repository.CustomerRepository;
import com.example.Prep.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	private Customer customer;
	private CustomerEntity customerEntity;

}
