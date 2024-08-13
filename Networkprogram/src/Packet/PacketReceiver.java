package Packet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PacketReceiver {
	public static void main(String[] args) throws Exception {
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		DatagramSocket socket = new DatagramSocket(5002);
		socket.receive(packet);
		System.out.println(packet.getSocketAddress());
		buffer = packet.getData();
		System.out.println(new String(buffer));
	}
}