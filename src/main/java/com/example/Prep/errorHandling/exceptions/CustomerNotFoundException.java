package com.example.Prep.errorHandling.exceptions;

/**
 * This exception is created for CustomerNotFound scenario and to handle it gracefully.
 * It extends RuntimeException class.
 * 
 * @author: Manas Vishnoi
 */
public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();

	}

	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}

}
