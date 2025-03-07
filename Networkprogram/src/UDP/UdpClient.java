package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        final String SERVER_HOSTNAME = "192.168.100.4";
        final int SERVER_PORT = 5555;
        final String CLIENT_NAME = "write_your_name";
        try {
            System.out.println("/* * * * * * * * * * * * * * * * * * * * * * * * * * */");
            System.out.println("\t\tUDP CLIENT");
            System.out.println("/* * * * * * * * * * * * * * * * * * * * * * * * * * */");
            // Resolve server IP address
            InetAddress serverIPAddress = InetAddress.getByName(SERVER_HOSTNAME);
            System.out.println("Attempting to send to " + serverIPAddress + " via UDP port " + SERVER_PORT + "\n");
            // Create the client socket
            DatagramSocket clientSocket = new DatagramSocket();
            // Prepare the message to send
            String message = "Hello from " + CLIENT_NAME + " sent by the host: " + InetAddress.getLocalHost();
            byte[] sendData = message.getBytes();

            // Create and send the packet
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);
            clientSocket.send(sendPacket);
            // Close the socket
            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
