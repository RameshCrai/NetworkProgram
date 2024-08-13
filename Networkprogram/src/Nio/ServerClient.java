/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nio;

/**
 *
 * @author shree
 */
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
public class ServerClient {
  
      public static void main(String[] args) {
          try {
              String[] messages = {"I like non-blocking servers", "Hello non-blocking world!", "One more message..", "exit"};
              System.out.println("Starting client...");
              SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 8080));
  
              for (String msg : messages) {
                  System.out.println("Prepared message: " + msg);
                  ByteBuffer buffer = ByteBuffer.allocate(1024);
                  buffer.put(msg.getBytes());
                  buffer.flip();
                  int bytesWritten = client.write(buffer);
                  System.out.println(String.format("Sending Message: %s\nbufforBytes: %d", msg, bytesWritten));
              }
  
              client.close();
              System.out.println("Client connection closed");
  
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
