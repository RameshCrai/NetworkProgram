package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exp24_SecureHttpClient {
	public static void main(String[] args) {
		String urlString = "https://jsonplaceholder.typicode.com/posts/1";
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println("Response: " + response.toString());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
