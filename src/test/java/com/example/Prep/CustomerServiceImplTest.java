package com.example.Prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Prep.dto.request.Customer;
import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.repository.CustomerRepository;
import com.example.Prep.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@Mock
	PasswordEncoder passwordEncoder;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	private Customer customer;
	private CustomerEntity customerEntity;

	@Test
	void addCustomerTest() {

		customer = new Customer();

		customer.setCustomerId("something");
		customer.setEmail("soomething@email.com");
		customer.setEnabled(false);
		customer.setPassword("somepassword");
		customer.setUsername("some-username");

		customerEntity = new CustomerEntity();

		Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(customerEntity);

		customerServiceImpl.addCustomer(customer);

		Mockito.validateMockitoUsage();

	}

	@Test
	void readCustomerTest() {

		customerEntity = new CustomerEntity();

		customerEntity.setCustomerId(1234);
		customerEntity.setEmail("someemail");
		customerEntity.setEnabled(false);

		Mockito.when(customerRepository.findByusername("someusername")).thenReturn(customerEntity);

		customerServiceImpl.readCustomer("someusername");

		assertEquals(1234, customerEntity.getCustomerId());

	}

	@Test
	void checkIfUserExistsTest() {

		customerEntity = new CustomerEntity();

		customerEntity.setCustomerId(1234);
		customerEntity.setEmail("someemail");
		customerEntity.setEnabled(false);
		customerEntity.setRole("somerole");

		Mockito.when(customerRepository.findByemail("someemail")).thenReturn(customerEntity);

		boolean response = customerServiceImpl.checkIfCustomerExists("someemail");

		assertEquals(true, response);

		Mockito.when(customerRepository.findByemail("someemail")).thenReturn(null);
		boolean responseFalse = customerServiceImpl.checkIfCustomerExists("someemail");

		assertEquals(false, responseFalse);

	}

}
