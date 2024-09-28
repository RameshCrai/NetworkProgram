package Lab;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class Exp5_ReachabilityTest {

    public static void main(String[] args) {
        String host = "www.google.com";  

        try {
            InetAddress inetAddress = InetAddress.getByName(host);

            System.out.println("Testing reachability of host: " + host);
            if (inetAddress.isReachable(5000)) {
                System.out.println(host + " is reachable.");
            } else {
                System.out.println(host + " is not reachable.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Host unknown: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }
}
