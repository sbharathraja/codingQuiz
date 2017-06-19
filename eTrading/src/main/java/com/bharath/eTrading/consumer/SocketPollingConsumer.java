package com.bharath.eTrading.consumer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.bharath.eTrading.processing.TradingDispatcher;

/**
 * 
 * Act as a listening bean to poll for trading symbol from client. Polling
 * interval can be manipulated via properties file. This is typically server
 * side of the socket programming.
 * 
 * @author Bharath Raja
 *
 */
public class SocketPollingConsumer {

	public static void main(String[] args) throws ConsumerException {
		try {
			System.out.println("Started the polling consumer....");
			Integer portNumber = Integer
					.valueOf((String) ETradingUtil.getServerProperty(ETradingConstants.PROP_KEY_SERVER_SOCKET_PORT));
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket socket = serverSocket.accept();
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());

			Integer maximumNumberOfPoll = Integer
					.valueOf(ETradingUtil.getServerProperty(ETradingConstants.PROP_KEY_SERVER_MAX_NO_POLL));
			System.out.println("Maximum number of poll configured is :" + maximumNumberOfPoll);

			Long pollingInterval = Long
					.valueOf(ETradingUtil.getServerProperty(ETradingConstants.PROP_KEY_SERVER_POLLING_INTERVAL));
			int pollingCount = 1;

			TradingDispatcher dispatcher = new TradingDispatcher();
			List<Future<ETradingResponse>> tradingResult = new ArrayList<Future<ETradingResponse>>();
			while (pollingCount <= maximumNumberOfPoll) {
				String tradingSymbol = inputStream.readUTF();
				System.out.println("Received the polling symbol :" + tradingSymbol);
				ETradingSymbol symbol = new ETradingSymbol(tradingSymbol);
				dispatcher.dispatchForProcessing(symbol, tradingResult);
				Thread.sleep(pollingInterval);
				pollingCount++;
			}
			displayResponse(tradingResult);
			dispatcher.shutDownDispatcher();
			serverSocket.close();
			System.out.println("Completed the polling consumer....");
		} catch (IOException e) {
			throw new ConsumerException("Error occurred while trying to poll the consumer", e);
		} catch (InterruptedException e) {
			throw new ConsumerException("Error occurred while trying to make the symbol polling", e);
		} catch (ExecutionException e) {
			throw new ConsumerException("Erroc occurred while trying to get the processing response", e);
		}
	}

	/**
	 * Helps to print the given trading response.
	 * 
	 * @param tradingResult
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	private static void displayResponse(List<Future<ETradingResponse>> tradingResult)
			throws InterruptedException, ExecutionException {
		for (Future<ETradingResponse> tradingResponse : tradingResult) {
			ETradingResponse response = tradingResponse.get();
			System.out.println("Response =" + response);
		}
	}

}
