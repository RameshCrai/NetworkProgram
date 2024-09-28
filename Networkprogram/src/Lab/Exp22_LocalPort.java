package Lab;

import java.net.BindException;
import java.net.ServerSocket;

public class Exp22_LocalPort {
	public static void main(String[] args) {
		int portRange = 1024;
		System.out.println("Checking local machine ports...");

		for (int port = 1; port <= portRange; port++) {
			try {
				ServerSocket serverSocket = new ServerSocket(port);
				serverSocket.close();
			} catch (BindException e) {
				System.out.println("Port " + port + " is unavailable.");
			} catch (Exception e) {
				System.err.println("Error checking port " + port + ": " + e.getMessage());
			}
		}
		System.out.println("Port checking completed.");
	}
}
