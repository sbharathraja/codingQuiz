package com.bharath.eTrading.consumer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 * Helps to run the unit test on {@link ETradingUtil}
 * 
 * @author Bharath Raja
 *
 */
public class ETradingUtilTest {

	@Test
	public void testGetServerProperty() throws IOException {
		try {
			ETradingUtil.getServerProperty(null);
			fail("Exception expected!");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			ETradingUtil.getServerProperty("");
			fail("Exception expected!");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertNull(ETradingUtil.getServerProperty("null"));
		assertNotNull(ETradingUtil.getServerProperty(ETradingConstants.PROP_KEY_SERVER_SOCKET_PORT));
	}

	@Test
	public void testGetClientProperty() throws IOException {
		try {
			ETradingUtil.getClientProperty(null);
			fail("Exception expected!");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			ETradingUtil.getClientProperty("");
			fail("Exception expected!");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertNull(ETradingUtil.getClientProperty("null"));
		assertNotNull(ETradingUtil.getClientProperty(ETradingConstants.PROP_KEY_SERVER_HOST));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(ETradingUtil.isEmpty(null));
		assertTrue(ETradingUtil.isEmpty(""));
		assertTrue(ETradingUtil.isEmpty(" "));
		assertTrue(ETradingUtil.isEmpty("    "));
		assertFalse(ETradingUtil.isEmpty("a"));
		assertFalse(ETradingUtil.isEmpty("124"));
		assertFalse(ETradingUtil.isEmpty("123 "));
	}

}
