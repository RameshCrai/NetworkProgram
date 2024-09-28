package Lab;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Exp30_ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            new MessageReceiver(socket).start(); 
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class MessageReceiver extends Thread {
        private Socket socket;
        private BufferedReader in;

        public MessageReceiver(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received from server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
