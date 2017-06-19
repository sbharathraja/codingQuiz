package com.bharath.eTrading.client;

/**
 * Generic exception to handle on the socket client side.
 * 
 * @author Bharath Raja
 *
 */
public class ClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4389134889038705688L;

	public ClientException(String message) {
		super(message);
	}

	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientException() {
		super();
	}

	public ClientException(Throwable cause) {
		super(cause);
	}

}
