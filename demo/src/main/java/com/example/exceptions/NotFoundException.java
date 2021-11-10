package com.example.exceptions;

public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_STRING = "NOT FOUND";
	
	public NotFoundException() {
		this(MESSAGE_STRING);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		this(MESSAGE_STRING, cause);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
