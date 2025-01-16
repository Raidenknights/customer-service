package com.example.Prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.example.Prep.controller.CustomerController;
import com.example.Prep.dto.request.Customer;
import com.example.Prep.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@Mock
	Authentication authentication;

	@InjectMocks
	CustomerController customerController;

	private Customer customer;

	@Test
	void createUserTest() {

		customer = new Customer();

		customer.setCustomerId("someid");
		customer.setEmail("someemailid");
		customer.setEnabled(false);
		customer.setPassword("somePassword");

		Mockito.doNothing().when(customerService).addCustomer(Mockito.any(Customer.class));

		customerController.createUser(customer);

		Mockito.verify(customerService).addCustomer(customer);
	}

	@Test
	void checkIfUserExistsTest() {

		Mockito.when(customerService.checkIfCustomerExists("someemail")).thenReturn(false);
		ResponseEntity<Boolean> responseFail = customerController.checkIfCustomerExists("someemail");

		assertEquals(false, responseFail.getBody());

		Mockito.when(customerService.checkIfCustomerExists("someemail")).thenReturn(true);
		ResponseEntity<Boolean> responseTrue = customerController.checkIfCustomerExists("someemail");

		assertEquals(true, responseTrue.getBody());
	}

	@Test
	void fetchCustomerByUserNameTest() {

		customer = new Customer();

		customer.setCustomerId("someid");
		customer.setEmail("someemailid");
		customer.setEnabled(false);
		customer.setPassword("somePassword");

		Mockito.when(authentication.getName()).thenReturn("mockUsername");
		Mockito.when(customerService.readCustomer("mockUsername")).thenReturn(customer);

		customerController.fetchCustomerByUserName(authentication);

		assertEquals("someid", customer.getCustomerId());
	}

}
