package Project;

import java.net.*;
import java.net.UnknownHostException;

public class AddressHosting {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
			InetAddress address2 = InetAddress.getByName("www.fb.com");
			System.out.println(address2.getHostAddress());
			System.out.println(address2.getHostName());

		} catch (UnknownHostException ex) {
			System.out.println("I'm sorry. I don't know my own address.");
		}
	}
}
