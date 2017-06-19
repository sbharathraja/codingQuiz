package com.bharath.eTrading.consumer;

/**
 * Act as a container to hold the trading symbol
 * 
 * @author Bharath Raja
 *
 */
public final class ETradingSymbol {

	private final String symbol;

	public ETradingSymbol(String symbol) {
		if (ETradingUtil.isEmpty(symbol)) {
			throw new IllegalArgumentException("symbol cannot be null or empty");
		}
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return ETradingSymbol.class.getCanonicalName() + ", symbol =" + symbol;
	}

}
