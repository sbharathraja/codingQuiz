package com.bharath.eTrading.consumer;

/**
 * Common exception type which declares the exception occuring in server side.
 * 
 * @author Bharath Raja
 *
 */
public class ConsumerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8044474944704339685L;

	public ConsumerException(String message) {
		super(message);
	}

	public ConsumerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConsumerException() {
		super();
	}

	public ConsumerException(Throwable cause) {
		super(cause);
	}

}
