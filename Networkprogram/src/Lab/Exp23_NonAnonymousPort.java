package Lab;

import java.io.IOException;
import java.net.ServerSocket;

public class Exp23_NonAnonymousPort {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(0);
            int assignedPort = serverSocket.getLocalPort();
            System.out.println("Assigned non-anonymous port: " + assignedPort);
        } catch (IOException e) {
            System.err.println("Could not create a server socket: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("Could not close the server socket: " + e.getMessage());
                }
            }
        }
    }
}
