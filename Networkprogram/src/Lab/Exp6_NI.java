package Lab;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Exp6_NI {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();

				System.out.println("Interface Name: " + networkInterface.getName());
				System.out.println("Display Name: " + networkInterface.getDisplayName());

				if (networkInterface.isUp()) {
					System.out.println("Status: Up");
				} else {
					System.out.println("Status: Down");
				}

				if (networkInterface.supportsMulticast()) {
					System.out.println("Supports Multicast: Yes");
				} else {
					System.out.println("Supports Multicast: No");
				}
				if (networkInterface.isLoopback()) {
					System.out.println("Loopback: Yes");
				} else {
					System.out.println("Loopback: No");
				}
				System.out.println("------------------------------------");
			}

		} catch (SocketException e) {
			System.out.println("Error accessing network interfaces: " + e.getMessage());
		}
	}
}
