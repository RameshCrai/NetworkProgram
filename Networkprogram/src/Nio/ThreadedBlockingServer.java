/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nio;

/**
 *
 * @author shree
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8080); // Creating the server on port 8080
        while (true) {
            // Accept means it will accept the incoming connection
            final Socket socket = serverSocket.accept(); // Blocking until someone connects
            new Thread(() -> handle(socket)).start();
        }
    }

    /**
     * Read from socket and do operation and then write back on socket.
     */
    private static void handle(final Socket socket) {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            int data;
            while ((data = inputStream.read()) != -1) { // -1 -> end of stream
                // Data read from socket

                // Operation performed
                data = Character.isLetter(data) ? invertCase(data) : data;

                // Changed output written back to socket
                outputStream.write(data);
            }
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static int invertCase(final int data) {
        return Character.isUpperCase(data)
                ? Character.toLowerCase(data)
                : Character.toUpperCase(data);
    }
}
