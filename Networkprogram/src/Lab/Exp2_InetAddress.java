package Lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exp2_InetAddress {
	public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");

            System.out.println("Host Name: " + address.getHostName());

            // Display the IP address in textual form
            System.out.println("IP Address: " + address.getHostAddress());

            // Get the local host information
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localAddress.getHostName());
            System.out.println("Local IP Address: " + localAddress.getHostAddress());

            // Get all IP addresses associated with the given host name
            InetAddress[] allAddresses = InetAddress.getAllByName("www.google.com");
            for (InetAddress addr : allAddresses) {
                System.out.println("Google IP Address "+addr.getHostAddress());
            }

        } catch (UnknownHostException e) {
            // Handle the exception if the host is unknown
            System.out.println("Unknown host exception: " + e.getMessage());
        }
	}
}
