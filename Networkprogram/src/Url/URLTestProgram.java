package Url;
import java.net.*;

public class URLTestProgram {
	public static void main(String[] args) {
		URL webpage = null;
		try {
    		webpage = new URL("http", "www.apple.com", 80, "/ipad/index.html");
		} catch(MalformedURLException e) {
		    e.printStackTrace();
		}
		System.out.println(webpage);
		System.out.println("protocol = " + webpage.getProtocol());
		System.out.println("host = " + webpage.getHost());
		System.out.println("filename = " + webpage.getFile());
		System.out.println("port = " + webpage.getPort());
		System.out.println("ref = " + webpage.getRef());
	}
}
