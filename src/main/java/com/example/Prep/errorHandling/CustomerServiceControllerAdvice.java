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

/**
 * This class act as a exception handler for the spring-boot application.
 * 
 * @author Manas Vishnoi
 */
@ControllerAdvice
@RestController
public class CustomerServiceControllerAdvice {

	/**
	 * This exception is to be thrown or to be handled if email is already in use.
	 * 
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(EmaiAlreadyInUseException.class)
	public ResponseEntity<String> emaiAlreadyInUseException(EmaiAlreadyInUseException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * This exception will handle when user name already exist.
	 * 
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<String> usernameAlreadyExistsException(UsernameAlreadyExistsException ex) {

		System.out.println(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Raised if entity doesn't exist.
	 * 
	 * @param ex
	 * @param webRequest
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest webRequest) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Generic exception handling for all exceptions if not defined explicitly.
	 * 
	 * @param ex
	 * @param webRequest
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest webRequest) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
