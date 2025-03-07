package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {

	private static final int TELNET_PORT = 8080;
	private static final int BUFFLEN = 1024;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(TELNET_PORT);
		Socket clientSocket = serverSocket.accept();
		InetSocketAddress remote = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
		System.out.println("connection from port=" + remote.getPort() + " host=" + remote.getHostName());
		InputStream in = clientSocket.getInputStream();
		OutputStream out = clientSocket.getOutputStream();
		byte[] buffer = new byte[BUFFLEN];
		while (clientSocket.isConnected()) {
			int len = in.read(buffer);
			if (len > 0) {
				out.write(buffer, 0, len);
			}
		}
	}
}