package Url;
import java.net.*;
import java.io.*;

public class URLReaderProgram {
    public static void main(String[] args) {
        URL wiki = null;
        try {
            wiki = new URL("https://en.wikipedia.org/wiki/Computer_science");
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(wiki.openStream()));
            // Now read the webpage file
            String lineOfWebPage;
            while ((lineOfWebPage = in.readLine()) != null)
                System.out.println(lineOfWebPage);
            in.close(); // Close the connection to the net
        } catch(MalformedURLException e) {
            System.out.println("Cannot find webpage " + wiki);
        } catch(IOException e) {
            System.out.println("Cannot read from webpage " + wiki);
        }
    }
}
