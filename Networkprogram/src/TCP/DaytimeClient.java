package TCP;

import java.net.*;
import java.io.*;

public class DaytimeClient {
	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		System.out.println("host =="+hostname);
		Socket socket = null;
		try {
			socket = new Socket(hostname, 13);
			System.out.println("socket ="+socket);
			socket.setSoTimeout(60000);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char) c);
			}
			System.out.println(time);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ex) {
// ignore
				}
			}
		}
	}
}
