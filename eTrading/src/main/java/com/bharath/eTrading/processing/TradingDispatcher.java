package com.bharath.eTrading.processing;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bharath.eTrading.consumer.ETradingConstants;
import com.bharath.eTrading.consumer.ETradingResponse;
import com.bharath.eTrading.consumer.ETradingSymbol;
import com.bharath.eTrading.consumer.ETradingUtil;

/**
 * Act as a dispatcher to process the trading symbol.
 * 
 * @author Bharath Raja
 *
 */
public class TradingDispatcher {

	private ExecutorService dispatcherService;

	/**
	 * Helps to construct the dispatcher service with configured server props.
	 * 
	 * @throws IOException
	 */
	public TradingDispatcher() throws IOException {
		Integer threadPoolSize = Integer
				.valueOf(ETradingUtil.getServerProperty(ETradingConstants.PROP_KEY_MAX_THREAD_POOL_SIZE));
		dispatcherService = Executors.newFixedThreadPool(threadPoolSize);
		System.out.println("Created dispatching service");
		System.out.println("Maximum of threads in pool is : " + threadPoolSize);
	}

	/**
	 * Helps to dispatch the given trading symbol request for processing; the
	 * result can be collect from given trading result list.
	 * 
	 * @param symbol
	 * @param tradingResult
	 */
	public void dispatchForProcessing(ETradingSymbol symbol, List<Future<ETradingResponse>> tradingResult) {
		if (null == tradingResult) {
			throw new IllegalArgumentException("Trading Result cannot be null!");
		}
		Future<ETradingResponse> callableResponse = dispatcherService.submit(new TradingProcessCallable(symbol));
		tradingResult.add(callableResponse);
	}

	/**
	 * Helps to shut down the binded dispatching service.
	 */
	public void shutDownDispatcher() {
		this.dispatcherService.shutdown();
	}

}
