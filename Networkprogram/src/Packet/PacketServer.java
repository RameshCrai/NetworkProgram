package Packet;
import java.net.*;
import java.io.*;

public class PacketServer {
    public  static int SERVER_PORT = 5000;
    private static int INPUT_BUFFER_LIMIT = 500;
    private int counter = 0;
    
    // Helper method to get the DatagramSocket started
    private DatagramSocket goOnline() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(SERVER_PORT);
            System.out.println("SERVER online");
        } catch (SocketException e) {
            System.out.println("SERVER: no network connection");
            System.exit(-1);
        }
        return socket;
    }
    
    // Handle all requests
    private void handleRequests(DatagramSocket socket) {
        while(true) {
            try {
                // Wait for an incoming client request
                byte[] recieveBuffer = new byte[INPUT_BUFFER_LIMIT];
                DatagramPacket receivePacket;
                receivePacket = new DatagramPacket(recieveBuffer,
                                                   recieveBuffer.length);
                socket.receive(receivePacket);
                
                // Extract the packet data that contains the request
                InetAddress address = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String request = new String(receivePacket.getData(), 0,
                                            receivePacket.getLength());
                System.out.println("SERVER: Packet received: \"" + request +
                                   "\" from " + address + ":" + clientPort);
                
                
                
                // Decide what should be sent back to the client
                byte[] sendBuffer;
                if (request.equals("What Time is It ?")) {
                    System.out.println("SERVER: sending packet with time info");
                    sendResponse(socket, address, clientPort,
                                 new java.util.Date().toString().getBytes());
                    counter++;
                }
                else if (request.equals("How many requests have you handled ?")) {
                    System.out.println("SERVER: sending packet with num requests");
                    sendResponse(socket, address, clientPort,
                                 ("" + ++counter).getBytes());
                }
                else
                    System.out.println("SERVER: Unknown request: " + request);
            } catch(IOException e) {
                System.out.println("SERVER: Error receiving client requests");
            }
        }
    }
    
    // This helper method sends a given response back to the client
    private void sendResponse(DatagramSocket socket, InetAddress address,
                              int clientPort, byte[] response) {
        try {
            // Now create a packet to contain the response and send it
            DatagramPacket sendPacket = new DatagramPacket(response,
                                                           response.length, address, clientPort);
            socket.send(sendPacket);
        } catch (IOException e) {
            System.out.println("SERVER: Error sending response to client");
        }
    }
    
    public static void main (String args[]) {
        PacketServer s = new PacketServer();
        DatagramSocket ds = s.goOnline();
        if (ds != null)
            s.handleRequests(ds);
    }
}
