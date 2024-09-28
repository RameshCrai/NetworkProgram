package Lab;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Exp14_ProxySelector {

    public static void main(String[] args) {
        // URI to connect to
        URI uri = URI.create("http://www.example.com");

        // Get the default ProxySelector
        ProxySelector defaultSelector = ProxySelector.getDefault();

        // Get the list of proxies for the given URI
        List<Proxy> proxies = defaultSelector.select(uri);
        
        // Store available proxies
        List<Proxy> rememberedProxies = new ArrayList<>();

        // Iterate through the proxies and display them
        for (Proxy proxy : proxies) {
            System.out.println("Proxy: " + proxy);
            if (proxy.type() != Proxy.Type.DIRECT) {
                rememberedProxies.add(proxy);
            }
        }

        // Demonstrate remembered proxies
        System.out.println("\nRemembered Proxies:");
        for (Proxy proxy : rememberedProxies) {
            System.out.println("Remembered Proxy: " + proxy.address());
        }

        // Example connection using a remembered proxy
        if (!rememberedProxies.isEmpty()) {
            connectUsingProxy(rememberedProxies.get(0), uri);
        }
    }

    // Method to demonstrate connecting through a proxy
    private static void connectUsingProxy(Proxy proxy, URI uri) {
        SocketAddress address = proxy.address();
        System.out.println("\nConnecting through proxy: " + address);

        // Create a socket to connect through the proxy
        try (java.net.Socket socket = new java.net.Socket(proxy)) {
            socket.connect(new InetSocketAddress(uri.getHost(), 80)); // Connect to the target host
            System.out.println("Connected to " + uri + " through " + proxy);
        } catch (IOException e) {
            System.out.println("Failed to connect through proxy: " + e.getMessage());
        }
    }
}
