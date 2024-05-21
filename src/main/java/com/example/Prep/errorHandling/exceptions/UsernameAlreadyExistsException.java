package com.example.Prep.errorHandling.exceptions;

/**
 * This is a custom exception created to handle already existing user name
 * @author Manas Vishnoi
 */
public class UsernameAlreadyExistsException extends RuntimeException {

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}
