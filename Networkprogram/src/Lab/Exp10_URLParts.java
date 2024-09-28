package Lab;

import java.net.URL;

public class Exp10_URLParts {

	public static void main(String[] args) {
		try {
			String urlString = "http://www.example.com:80/path/to/resource?query=param#fragment";
			URL url = new URL(urlString);

			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort() != -1 ? url.getPort() : url.getDefaultPort();
			String path = url.getPath();
			String query = url.getQuery();
			String fragment = url.getRef();

			System.out.println("Protocol: " + protocol);
			System.out.println("Host: " + host);
			System.out.println("Port: " + port);
			System.out.println("Path: " + path);
			System.out.println("Query: " + query);
			System.out.println("Fragment: " + fragment);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
