package Lab;

import java.io.*;
import java.net.*;
import java.util.*;

public class Exp30_ChatServer {
    private static Set<Socket> clientSockets = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("New client connected: " + clientSocket);
            
            new ClientHandler(clientSocket).start();
        }
    }
    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    clientSockets.remove(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            for (Socket clientSocket : clientSockets) {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
