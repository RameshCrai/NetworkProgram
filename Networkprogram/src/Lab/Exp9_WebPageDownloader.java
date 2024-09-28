package Lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Exp9_WebPageDownloader {

    public static void main(String[] args) {
        String urlString = "http://www.example.com";

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            System.out.println("Web page content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close(); 
        } catch (Exception e) {
            System.out.println("Error downloading web page: " + e.getMessage());
        }
    }
}
