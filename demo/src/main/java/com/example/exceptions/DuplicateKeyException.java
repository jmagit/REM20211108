package com.example.exceptions;

public class DuplicateKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_STRING = "DUPLICATE KEY";
	
	public DuplicateKeyException() {
		this(MESSAGE_STRING);
	}

	public DuplicateKeyException(String message) {
		super(message);
	}

	public DuplicateKeyException(Throwable cause) {
		this(MESSAGE_STRING, cause);
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
