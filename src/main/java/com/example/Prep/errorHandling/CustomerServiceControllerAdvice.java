package com.example.Prep.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Prep.errorHandling.exceptions.UsernameNotFoundException;

@ControllerAdvice
public class CustomerServiceControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<String> userNotFoundException(UsernameNotFoundException ex) {

		return new ResponseEntity<>("Username not found", HttpStatus.NOT_FOUND);
	}

}
