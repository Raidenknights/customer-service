package com.example.Prep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	@Before
	void setUp() {
		customer = new Customer();
		customer.setCustomerId("1");
		customer.setUsername("Username");

		customerEntity = new CustomerEntity();
		customerEntity.setCustomerId("1");
		customerEntity.setUsername("Username");
		customerEntity.setEnabled(true);
		customerEntity.setPassword("Password");
		customerEntity.setRegistrationDate(new Date());
		customerEntity.setRole("role");
	}

	@Test
	public void readCustomerTest() {

		customerEntity = new CustomerEntity();
		customerEntity.setCustomerId("1");
		customerEntity.setUsername("Username");
		customerEntity.setEnabled(true);
		customerEntity.setPassword("Password");
		customerEntity.setRegistrationDate(new Date());
		customerEntity.setRole("role");

		Mockito.when(customerRepository.findByusername("Username")).thenReturn(customerEntity);

		Customer customer = customerServiceImpl.readCustomer("Username");

		assertEquals("Username", customer.getUsername());
	}

	@Test
	public void addCustomerTest() {

	}

}
