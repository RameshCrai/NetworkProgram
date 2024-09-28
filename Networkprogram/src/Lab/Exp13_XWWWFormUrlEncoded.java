package Lab;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Exp13_XWWWFormUrlEncoded {

    public static void main(String[] args) {
        try {
            String name = "Ramesh Rai";
            String email = "Ramesh.dev@example.com";
            String message = "Hello, world!";

            String encodedData = encodeData(name, email, message);
            System.out.println("Encoded Data: " + encodedData);

            decodeData(encodedData);

        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String encodeData(String name, String email, String message) 
    		throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("name=").append(URLEncoder.encode(name, StandardCharsets.UTF_8.toString()));
        sb.append("&email=").append(URLEncoder.encode(email, StandardCharsets.UTF_8.toString()));
        sb.append("&message=").append(URLEncoder.encode(message, StandardCharsets.UTF_8.toString()));
        return sb.toString();
    }

    public static void decodeData(String encodedData) throws UnsupportedEncodingException {
        String[] pairs = encodedData.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8.toString());
            String value = URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8.toString());
            System.out.println(key + ": " + value);
        }
    }
}
