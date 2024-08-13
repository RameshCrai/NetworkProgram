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
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBlockingServer {

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocket = ServerSocketChannel.open(); 
// Creating the server on port 8080

        // Binding this server on the port
        serverSocket.bind(new InetSocketAddress("localhost", 8080));

        while (true) {
            // Accept means it will accept the incoming connection
            // This is again Blocking even if its java NIO.
            final SocketChannel socket = serverSocket.accept(); // Blocking until someone connects

            handle(socket);
        }
    }

    /**
     * Read from socket and do operation and then write back on socket.
     *
     * @param socket
     */
    private static void handle(final SocketChannel socket) {
        final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(80); // Allocate to Native memory

        try {
            int data;
            while ((data = socket.read(byteBuffer)) != -1) { // -1 -> end of stream
                // Data read from socket
                byteBuffer.flip();

                // Operation performed
                invertCase(byteBuffer);

                // Changed output written back to socket
                while (byteBuffer.hasRemaining()) {
                    // OutputStream write everything together, but ByteBuffer doesn't not, so this loop is required
                    socket.write(byteBuffer);
                }

                // It will set the position=0 and limit=80
                byteBuffer.compact();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void invertCase(final ByteBuffer byteBuffer) {
        for (int x = 0; x < byteBuffer.limit(); x++) { // read every byte in it.
            byteBuffer.put(x, (byte) invertCase(byteBuffer.get(x)));
        }
    }

    private static int invertCase(final int data) {
        return Character.isLetter(data) ?

                Character.isUpperCase(data)
                        ? Character.toLowerCase(data)
                        : Character.toUpperCase(data) :

                data;
    }
}
