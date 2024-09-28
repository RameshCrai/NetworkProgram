package Lab;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Exp25_NonBlockingIO {
	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.bind(new InetSocketAddress(8080));
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("Server is listening on port 8080...");

			while (true) {
				selector.select();
				Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
				while (keyIterator.hasNext()) {
					SelectionKey key = keyIterator.next();

					// 6. Accept new connections
					if (key.isAcceptable()) {
						SocketChannel socketChannel = serverChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);
						System.out.println("Accepted new connection from " + socketChannel.getRemoteAddress());
					}

					// 7. Read data from channels
					if (key.isReadable()) {
						SocketChannel socketChannel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(256);
						int bytesRead = socketChannel.read(buffer);

						if (bytesRead == -1) {
							socketChannel.close();
						} else {
							buffer.flip();
							System.out.println("Received: " + new String(buffer.array(), 0, bytesRead));
							buffer.clear();
						}
					}

					keyIterator.remove();
				}
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
