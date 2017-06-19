package com.bharath.eTrading.consumer;

/**
 * Act as a container to hold the response after processing the trading symbol
 * 
 * @author Bharath Raja
 *
 */
public final class ETradingResponse {

	private final String response;

	public ETradingResponse(String response) {
		if (ETradingUtil.isEmpty(response)) {
			throw new IllegalArgumentException("Response cannot be null or empty!");
		}
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return ETradingResponse.class.getSimpleName() + ", response=" + response;
	}
}
