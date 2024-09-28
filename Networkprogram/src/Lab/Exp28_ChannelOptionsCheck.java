package Lab;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Exp28_ChannelOptionsCheck {
	public static void main(String[] args) {
		try {
			// Create a ServerSocketChannel that listens on port 8087
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(8087));
			System.out.println("Server is running and listening on port 8087...");

			// Wait for a connection from a client
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				System.out.println("Client connected: " + socketChannel.getRemoteAddress());
				socketChannel.close(); // Close connection after accepting
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
