package com.bharath.eTrading.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.bharath.eTrading.consumer.ETradingConstants;
import com.bharath.eTrading.consumer.ETradingUtil;

/**
 * Act as a client system to request the trading via socket.
 * 
 * @author Bharath Raja
 *
 */
public class ETradingClient {

	public static void main(String[] args) throws ClientException {
		try {
			System.out.println("Started the trading client....");
			String hostName = ETradingUtil.getClientProperty(ETradingConstants.PROP_KEY_SERVER_HOST);
			Integer portNumber = Integer
					.valueOf(ETradingUtil.getClientProperty(ETradingConstants.PROP_KEY_SERVER_SOCKET_PORT));
			Socket socket = new Socket(hostName, portNumber);
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			Integer maxNumberOfTradingRequest = Integer
					.valueOf(ETradingUtil.getClientProperty(ETradingConstants.PROP_KEY_MAX_NO_OF_SYMBOL_SIZE));
			for (int i = 1; i <= maxNumberOfTradingRequest; i++) {
				outStream.writeUTF(String.valueOf("Request " + i));
			}
			outStream.flush();
			outStream.close();
			socket.close();
			System.out.println("Completed the trading client....");
		} catch (IOException e) {
			throw new ClientException("Error occurred while trying to connect.", e);
		}
	}

}
