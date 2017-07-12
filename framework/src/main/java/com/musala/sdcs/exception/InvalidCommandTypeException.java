package com.musala.sdcs.exception;

public class InvalidCommandTypeException extends RuntimeException {

	private static final long serialVersionUID = -7977155340869778031L;

	/**
	 * Constructs a new exception with its detail message.
	 * 
	 * @param message
	 *            Detailed message
	 */
	public InvalidCommandTypeException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause
	 *            The cause
	 */
	public InvalidCommandTypeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            Detail message
	 * @param cause
	 *            The cause
	 */
	public InvalidCommandTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
