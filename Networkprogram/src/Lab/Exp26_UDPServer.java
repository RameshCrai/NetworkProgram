package Lab;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Exp26_UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        
        System.out.println("Server is running...");
        
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + message);
            
            String responseMessage = "Server: " + message;
            byte[] sendData = responseMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
            		receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);
        }
    }
}
