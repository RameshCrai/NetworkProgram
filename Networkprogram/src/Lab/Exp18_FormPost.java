package Lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Exp18_FormPost {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.tiktok.com/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Add User-Agent header
            connection.setDoOutput(true);

            String username = "Ramesh";
            String password = "12345";
            String formData = "username=" + URLEncoder.encode(username, "UTF-8") + "&password="
                    + URLEncoder.encode(password, "UTF-8");
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = formData.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(
                		connection.getInputStream(), "UTF-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Server Response: " + response.toString());
                }
            } else {
                System.out.println("Error: Unable to access the page. Response Code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
