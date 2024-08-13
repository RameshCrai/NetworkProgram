package Packet;
import java.net.*;
import java.io.*; 

public class PacketClientProgram {
    private static int INPUT_BUFFER_LIMIT = 500;
    
    private InetAddress localHost;
    
    public PacketClientProgram() {
        try {
            localHost = InetAddress.getLocalHost();
        } catch(UnknownHostException e) {
            System.out.println("CLIENT: Error connecting to network");
            System.exit(-1);
        }
    }
    
    // Ask the server for the current time 
    private void askForTime() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] sendBuffer = "What Time is It ?".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                                                           sendBuffer.length, localHost,
                                                           PacketServer.SERVER_PORT);
            System.out.println("CLIENT: Sending time request to server");
            socket.send(sendPacket);
        } catch(IOException e) {
            System.out.println("CLIENT: Error sending time request to server");
        }
        try {
            byte[] receiveBuffer = new byte[INPUT_BUFFER_LIMIT];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,
                                                              receiveBuffer.length);
            socket.receive(receivePacket);
            System.out.println("CLIENT: The time is " + new String(
                                                                   receivePacket.getData(), 0, 
                                                                   receivePacket.getLength()));
        } catch(IOException e) {
            System.out.println("CLIENT: Cannot receive time from server");
        }
        socket.close();
    }
    
    // Ask the server for the number of requests obtained 
    private void askForNumberOfRequests() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] sendBuffer = "How many requests have you handled ?".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                                                           sendBuffer.length, localHost,
                                                           PacketServer.SERVER_PORT);
            System.out.println("CLIENT: Sending request count request to server");
            socket.send(sendPacket);
        } catch(IOException e) {
            System.out.println("CLIENT: Error sending request to server");
        }
        try {
            byte[] receiveBuffer = new byte[INPUT_BUFFER_LIMIT];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,                                              
                                                              receiveBuffer.length);
            socket.receive(receivePacket);
            
            System.out.println("CLIENT: The number of requests are " +
                               new String(receivePacket.getData(), 0,                                                    receivePacket.getLength()));
        } catch(IOException e) {
            System.out.println("CLIENT: Cannot receive num requests from server");
        }
        socket.close();
    }
    
    // Ask the server to order a pizza 
    private void askForAPizza() {
        try {
            byte[] sendBuffer = "Give me a pizza".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                                                           sendBuffer.length, localHost,
                                                           PacketServer.SERVER_PORT);
            DatagramSocket socket = new DatagramSocket();
            System.out.println("CLIENT: Sending pizza request to server");
            socket.send(sendPacket);
            socket.close();
        } catch(IOException e) {
            System.out.println("CLIENT: Error sending request to server");
        }
    }
    
    private static void Delay() {
        try{Thread.sleep(3000);}catch(InterruptedException e){}
    }
    
    public static void main (String[] args) {
        PacketClientProgram c = new PacketClientProgram();
        Delay(); c.askForTime();
        Delay(); c.askForNumberOfRequests();
        Delay(); c.askForAPizza();
        Delay(); c.askForTime();
        Delay(); c.askForNumberOfRequests();
    }
    
}
