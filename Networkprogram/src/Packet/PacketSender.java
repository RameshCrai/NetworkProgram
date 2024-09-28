package Packet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class PacketSender {

	public static void main(String[] args) throws Exception {
		byte[] buffer = "data".getBytes();
		DatagramPacket packet =
				new DatagramPacket(buffer, buffer.length, new InetSocketAddress("localhost", 5002));
		DatagramSocket socket = new DatagramSocket(5003);
		socket.send(packet);
	}
}
