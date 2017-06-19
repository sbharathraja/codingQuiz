package com.bharath.eTrading.consumer;

/**
 * Provides constants which is been used across the system.
 * 
 * @author Bharath Raja
 *
 */
public final class ETradingConstants {

	private ETradingConstants() {

	}

	/**
	 * Server socket port number property key
	 */
	public static final String PROP_KEY_SERVER_SOCKET_PORT = "server.socket.port";

	/**
	 * server side polling interval.
	 */
	public static final String PROP_KEY_SERVER_POLLING_INTERVAL = "server.socket.polling.interval";

	/**
	 * max number of poll accepts in the server side.
	 */
	public static final String PROP_KEY_SERVER_MAX_NO_POLL = "server.max.number.poll";

	/**
	 * key to define the maximum number of thread pool
	 */
	public static final String PROP_KEY_MAX_THREAD_POOL_SIZE = "server.thread.pool.size";

	/**
	 * Key to define the maximum of number of trading symbol requested from
	 * server.
	 */
	public static final String PROP_KEY_MAX_NO_OF_SYMBOL_SIZE = "server.max.number.symbol.size";

	/**
	 * Key to define the name of the server host.
	 */
	public static final String PROP_KEY_SERVER_HOST = "server.host.name";
}
