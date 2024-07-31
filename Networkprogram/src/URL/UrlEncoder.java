package URL;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class UrlEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to encode:");

        String input = scanner.nextLine();

        try {
            // Encode the input string using UTF-8 encoding
            String encoded = URLEncoder.encode(input, "UTF-8");
            System.out.println("Encoded URL: " + encoded);
        } catch (UnsupportedEncodingException e) {
            System.err.println("UTF-8 encoding is not supported.");
        }
    }
}
