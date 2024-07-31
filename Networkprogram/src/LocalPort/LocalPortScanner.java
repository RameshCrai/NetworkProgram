package LocalPort;

import java.net.*;
import java.io.*;

public class LocalPortScanner {

	public static void main(String[] args) {

		for (int port = 1; port <= 65535; port++) {

			try {
				// the next line will fail and drop into the catch block if
				// there is already a server running on the port
				// make sure your firewalls are turned off as otherwise
				// you will get an error and it looks as if a port is active
				ServerSocket server = new ServerSocket(port);
				System.out.println("Port can be use for you " + port);
			} catch (IOException e) {
				System.out.println("There is a server on port ");
			} // end try

		}
	}
}