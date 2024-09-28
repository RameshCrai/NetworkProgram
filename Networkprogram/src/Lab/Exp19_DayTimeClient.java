package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Exp19_DayTimeClient {
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int port = 5000;

		try {
			Socket socket = new Socket(serverAddress, port);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverTime = in.readLine();
			System.out.println("Current Date and Time from Server: " + serverTime);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
