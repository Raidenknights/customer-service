package com.example.Prep.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.Prep.errorHandling.exceptions.EmaiAlreadyInUseException;
import com.example.Prep.errorHandling.exceptions.UsernameAlreadyExistsException;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
@RestController
public class CustomerServiceControllerAdvice {

	@ExceptionHandler(EmaiAlreadyInUseException.class)
	public ResponseEntity<String> emaiAlreadyInUseException(EmaiAlreadyInUseException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<String> usernameAlreadyExistsException(UsernameAlreadyExistsException ex) {

		System.out.println(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest webRequest) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest webRequest) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
