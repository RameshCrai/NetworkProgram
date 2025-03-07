package ThreadServer;

import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
			// Connect to the server on localhost and port 9090
			Socket socket = new Socket("localhost", 9090);

			// Set up input and output streams for communication
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String serverResponse;
			String clientMessage;

			System.out.println("Connected to the server. Type 'exit' to quit.");

			// Communication loop
			while (true) {
				System.out.print("Client: ");
				clientMessage = userInput.readLine();
				out.println(clientMessage);

				if (clientMessage.equalsIgnoreCase("exit")) {
					break;
				}

				serverResponse = in.readLine();
				System.out.println(serverResponse);
			}

			// Close the streams and socket
			in.close();
			out.close();
			socket.close();
			System.out.println("Connection closed");

		} catch (UnknownHostException e) {
			System.out.println("Server not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O error: " + e.getMessage());
		}
	}
}
