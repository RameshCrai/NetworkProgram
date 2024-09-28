package Lab;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exp19_DayTimeServer {
    public static void main(String[] args) {
        int port = 5000; 
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Day Time Server started. Waiting for clients...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                String currentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());              
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(currentTime);
                clientSocket.close();
                System.out.println("Sent date and time to the client and closed the connection.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
