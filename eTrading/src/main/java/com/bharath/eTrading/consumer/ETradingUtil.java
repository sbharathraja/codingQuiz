package com.bharath.eTrading.consumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provides utility methods over eTrading system.
 * 
 * @author Bharath Raja
 *
 */
public final class ETradingUtil {

	private static Properties consumerProperties;

	private static Properties clientProperties;

	private ETradingUtil() {

	}

	// helps to load the server side properties file.
	private static void loadServerProperties() throws IOException {
		if (null == consumerProperties) {
			consumerProperties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("consumer.properties");
			consumerProperties.load(stream);
			stream.close();
		}
	}

	private static void loadClientProperties() throws IOException {
		if (null == clientProperties) {
			clientProperties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("client.properties");
			clientProperties.load(stream);
			stream.close();
		}
	}

	/**
	 * Helps to get the property with given key from server properties file.
	 * 
	 * 
	 * @param key
	 * @return server property in string type.
	 * @throws IOException
	 */
	public static final String getServerProperty(String key) throws IOException {
		if (isEmpty(key)) {
			throw new IllegalArgumentException("Key cannot be null or empty!");
		}
		loadServerProperties();
		return consumerProperties.getProperty(key);
	}

	/**
	 * Helps to get the property with given key from client properties file.
	 * 
	 * @param key
	 * @return client property in string type.
	 * @throws IOException
	 */
	public static final String getClientProperty(String key) throws IOException {
		if (isEmpty(key)) {
			throw new IllegalArgumentException("key cannot be null or empty!");
		}
		loadClientProperties();
		return clientProperties.getProperty(key);
	}

	/**
	 * Decide whether given string value is empty or null.
	 * 
	 * @param value
	 * @return true if null or empty, false otherwise.
	 */
	public static final boolean isEmpty(String value) {
		if (null == value || value.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
