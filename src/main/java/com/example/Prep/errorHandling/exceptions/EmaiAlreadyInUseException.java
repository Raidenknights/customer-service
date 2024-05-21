package com.example.Prep.errorHandling.exceptions;

/**
 * This is a custom exception created to handle already existing email.
 * @author Manas Vishnoi
 */
public class EmaiAlreadyInUseException extends RuntimeException {

	public EmaiAlreadyInUseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmaiAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmaiAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmaiAlreadyInUseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmaiAlreadyInUseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
