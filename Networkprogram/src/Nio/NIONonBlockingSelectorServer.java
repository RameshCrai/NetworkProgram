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
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NIONonBlockingSelectorServer {

    // Every socket has its own ByteBuffer to operate independently.
    private static final Map<SocketChannel, ByteBuffer> sockets = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocket = ServerSocketChannel.open(); // Creating the server on port 8080

        // Binding this server on the port
        serverSocket.bind(new InetSocketAddress(8080));

        serverSocket.configureBlocking(false); // Make Server nonBlocking

        final Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT); // Interested only in Accept connection

        while (true) {
            selector.select(); // BLocks until something happens
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (Iterator<SelectionKey> it = selectionKeys.iterator(); it.hasNext(); ) {
                final SelectionKey key = it.next();
                it.remove(); // Remove to not get the same key again and again

                try {
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            accept(key); // Got something on Accept event
                        } else if (key.isWritable()) {
                            write(key); //// Got something on Write event
                        } else if (key.isReadable()) {
                            read(key); // Got something on Read event
                        }
                    }
                } catch (final IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

            // Remove sockets which are no longer open
            sockets.keySet().removeIf((socketChannel) -> !socketChannel.isOpen());
        }
    }

    // Once the Accept event is received, allocate the ByteBuffer and star reading from it(by getting interested in READ Operation)
    private static void accept(final SelectionKey key) throws IOException {
        ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socket = socketChannel.accept(); // Non Blocking BUT WILL ALWAYS HAVE SOME DATA(NEVER NULL)

        socket.configureBlocking(false); // Required, socket should also be NonBlocking

        socket.register(key.selector(), SelectionKey.OP_READ); // Interested only in Reading from the socket.

        // Every socket will have its own byte buffer
        sockets.put(socket, ByteBuffer.allocateDirect(80));
    }

    // Once the Read event is received, perform the operation on the input, and then write back once the
    // Write Operation is received.(So getting interested in Write Operation)
    private static void read(final SelectionKey key) throws IOException {
        final SocketChannel socket = (SocketChannel) key.channel();
        final ByteBuffer byteBuffer = sockets.get(socket);
        int data = socket.read(byteBuffer);

        if (data == -1) {
            closeSocket(socket);
            sockets.remove(socket);
        }

        byteBuffer.flip();
        invertCase(byteBuffer);

        socket.configureBlocking(false); // Required, socket should also be NonBlocking

        key.interestOps(SelectionKey.OP_WRITE);
        // Now listen for write, as the operation is done and we need to write it down.
    }

    // Once the Write event is received, write the associated ByteBuffer with this socket.
    private static void write(final SelectionKey key) throws IOException {
        final SocketChannel socket = (SocketChannel) key.channel();
        final ByteBuffer byteBuffer = sockets.get(socket); // Its already case inverted
        socket.write(byteBuffer); // Wont always write everything
        while (!byteBuffer.hasRemaining()) {
            byteBuffer.compact();
            key.interestOps(SelectionKey.OP_READ);
        }
    }

    private static void closeSocket(final SocketChannel socket) {
        try {
            socket.close();
        } catch (IOException ignore) {

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
