package com.example.Prep.errorHandling.exceptions;

/**
 * This is a custom exception created to handle already existing email.
 * 
 * @author Manas Vishnoi
 */
public class EmaiAlreadyInUseException extends RuntimeException {

	public EmaiAlreadyInUseException() {
		super();

	}

	public EmaiAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public EmaiAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);

	}

	public EmaiAlreadyInUseException(String message) {
		super(message);

	}

	public EmaiAlreadyInUseException(Throwable cause) {
		super(cause);

	}

}
