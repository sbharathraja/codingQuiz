package com.bharath.eTrading.processing;

import java.util.concurrent.Callable;

import com.bharath.eTrading.consumer.ETradingResponse;
import com.bharath.eTrading.consumer.ETradingSymbol;

/**
 * Responsible for running the trading process in separate thread.
 * 
 * @author Bharath Raja
 *
 */
public class TradingProcessCallable implements Callable<ETradingResponse> {

	private ETradingSymbol tradingRequest;

	public TradingProcessCallable(ETradingSymbol tradingSymbol) {
		if (null == tradingSymbol) {
			throw new IllegalArgumentException("Trading request cannot be null!");
		}
		this.tradingRequest = tradingSymbol;
	}

	public ETradingResponse call() throws Exception {
		System.out.println("Processing " + tradingRequest);
		ETradingResponse response = new ETradingResponse("Processed " + tradingRequest.getSymbol());
		return response;
	}

}
