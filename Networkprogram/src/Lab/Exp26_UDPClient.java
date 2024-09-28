package Lab;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Exp26_UDPClient {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData;
		byte[] receiveData = new byte[1024];
		Scanner scanner = new Scanner(System.in);

		System.out.println("Client is running...");

		while (true) {
			System.out.print("Enter message: ");
			String message = scanner.nextLine();
			sendData = message.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			socket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);

			String modifiedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("Received from server: " + modifiedMessage);
		}
	}
}
