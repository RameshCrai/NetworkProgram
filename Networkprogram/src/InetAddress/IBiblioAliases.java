package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IBiblioAliases {
	public static void main(String args[]) {
		try {
//			InetAddress ibiblio = InetAddress.getByName("www.facebook.com");
			InetAddress ibiblio = InetAddress.getByName("www.google.com");
			System.out.println(ibiblio);
//			InetAddress helios = InetAddress.getByName("www.fb.com");
			InetAddress helios = InetAddress.getByName("www.google.com.sa");
			System.out.println(helios);
			if (ibiblio.equals(helios)) {
				System.out.println(" is the same as");
			} else {
				System.out.println(" is not the same ");
			}
		} catch (UnknownHostException ex) {
			System.out.println("Host lookup failed.");
		}
	}
}
