package URL;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

public class UrlDecoder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter encoded URL:");
		String encodedUrl = scanner.nextLine();

		// Attempt to fix simple malformed encodings
		String fixedUrl = fixMalformedEncoding(encodedUrl);

		try {
			// Decode the URL using UTF-8 encoding
			String decodedUrl = URLDecoder.decode(fixedUrl, "UTF-8");
			System.out.println("Decoded URL: " + decodedUrl);
		} catch (IllegalArgumentException e) {
			// Catch the exception if the URL is still improperly encoded
			System.err.println("Invalid encoded URL format after fixing: " + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			// Catch the exception if UTF-8 encoding is not supported
			System.err.println("UTF-8 encoding is not supported.");
		}
	}

	// Method to attempt fixing simple malformed encoding
	private static String fixMalformedEncoding(String url) {
		// Replace any invalid % encoding sequences with a placeholder
		// You might want to implement more sophisticated fixing logic depending on your
		// needs
		return url.replaceAll("(?<!%)%(?![0-9A-Fa-f]{2})", "%25");
	}
}
