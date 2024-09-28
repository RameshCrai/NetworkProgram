package Lab;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Exp8_ProtocolSupportCheck {
	public static void checkTCP(String host, int port) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port), 2000);
			System.out.println("TCP connection to " + host + " on port " + port + " is supported.");
		} catch (IOException e) {
			System.out.println("TCP connection to " + host + " on port " + port + " is not supported.");
		}
	}

	public static void checkPing(String host) {
		try {
			InetAddress inet = InetAddress.getByName(host);
			if (inet.isReachable(3000)) {
				System.out.println("ICMP Ping to " + host + " is supported.");
			} else {
				System.out.println("ICMP Ping to " + host + " is not supported.");
			}
		} catch (IOException e) {
			System.out.println("ICMP Ping to " + host + " is not supported. Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		String host = "www.google.com";
		checkTCP(host, 80);
		checkPing(host);
	}
}
