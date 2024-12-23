package com.example.Prep;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Prep.controller.CustomerController;
import com.example.Prep.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;

}
