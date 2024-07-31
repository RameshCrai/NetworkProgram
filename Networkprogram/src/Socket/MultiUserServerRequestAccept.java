package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiUserServerRequestAccept {
	public static void main(String[] args) // throws Exception
	{
		try {
			ServerSocket serverSocket = new ServerSocket(9090);
			System.out.println("wainting for clients...");
			boolean stop = false;// without using
			while (!stop)// without using
			{// without using
				Socket socket = serverSocket.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Hello  client!");
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String clientInput = input.readLine();
				System.out.println(clientInput);
				input.close();
				out.close();
				socket.close();
			} // without using
			serverSocket.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
