package com.musala.sdcs.exception;

public class InvalidChannelTypeException extends RuntimeException {

	private static final long serialVersionUID = 1688806513039921138L;

	/**
	 * Constructs a new exception with its detail message.
	 * 
	 * @param message
	 *            Detailed message
	 */
	public InvalidChannelTypeException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause
	 *            The cause
	 */
	public InvalidChannelTypeException(Throwable cause) {
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
	public InvalidChannelTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
