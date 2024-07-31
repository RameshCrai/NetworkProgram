package Socket;

import java.io.*;
import java.net.*;

public class ServerSo {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9090);
		System.out.println("Waiting for server");
		Socket socket = serverSocket.accept();
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("Hello Client");
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String clientInput = input.readLine();
		System.out.println(clientInput);
		input.close();
		out.close();
		socket.close();
	}
}