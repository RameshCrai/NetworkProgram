package ThreadServer;

import java.io.*;
import java.net.*;

public class MultiThreadedServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9090);
			boolean stop = false;
			while (!stop) {
				System.out.println("Waiting for clients...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client is connected.");
				ClientThread clientThread = new ClientThread(clientSocket);
				clientThread.start();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}

class ClientThread extends Thread {
	private Socket clientSocket;

	public ClientThread(Socket socket) {
		this.clientSocket = socket;
	}

	@Override
	public void run() {
		try {
			// Get input and output streams for communication with the client
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			String clientMessage;
			// Keep reading messages from the client until "exit" is received
			while ((clientMessage = in.readLine()) != null) {
				System.out.println("Received: " + clientMessage);
				if (clientMessage.equalsIgnoreCase("exit")) {
					out.println("Goodbye!");
					break;
				}
				// Echo the message back to the client
				out.println("Server: " + clientMessage);
			}

			// Close the streams and socket after communication ends
			in.close();
			out.close();
			clientSocket.close();
			System.out.println("Client disconnected.");

		} catch (IOException e) {
			System.out.println("Error in client thread: " + e.getMessage());
		}
	}
}
