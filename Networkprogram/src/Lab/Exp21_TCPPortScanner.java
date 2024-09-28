package Lab;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exp21_TCPPortScanner {
	public static void main(String[] args) {
		String host = "localhost";
		int startPort = 1;
		int endPort = 1024;

		System.out.println("Scanning ports on host: " + host);

		for (int port = startPort; port <= endPort; port++) {
			try {
				Socket socket = new Socket(host, port);

				System.out.println("Port " + port + " is open (TCP Server running)");

				socket.close();
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				break;
			} catch (IOException e) {
			}
		}

		System.out.println("Port scanning completed.");
	}
}
