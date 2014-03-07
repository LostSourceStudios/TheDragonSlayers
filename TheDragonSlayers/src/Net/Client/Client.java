package Net.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client extends Thread {

	private InetAddress ipAddress;
	private DatagramSocket socket;
	int port = 0000;

	private String message;

	public Client(String ipAddress, int p) {
		try {
			this.port = p;
			this.socket = new DatagramSocket();
			this.ipAddress = InetAddress.getByName(ipAddress);
		} catch (UnknownHostException | SocketException e) {
		}
		System.out.println("Client > Started!");
	}

	public void run() {
		while (true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			message = new String(packet.getData());
			String[] array = message.trim().split("-");

			if (message.trim().substring(0, 2).equalsIgnoreCase("00")) {
				Clients.addPlayer(50, 50, message.trim().substring(2), "192.168.0.15", 0);
			}

			if (message.trim().substring(0, 2).equalsIgnoreCase("01")) {
				Clients.removePlayer(message.trim().substring(2));
			}

			if (message.trim().substring(0, 2).equalsIgnoreCase("02")) {
			}
			
			if (message.trim().substring(0, 2).equalsIgnoreCase("05")) {
				System.out.println("[CLIENT] Got level file!");
					System.out.println("[CLIENT] Got level file: " + array[1] + ", done!");
				
			}
			
			if (message.trim().substring(0, 2).equalsIgnoreCase("03")) {
			}

			if (message.trim().substring(0, 2).equalsIgnoreCase("09")) {
			}
			if (message.trim().substring(0, 2).equalsIgnoreCase("10")) {
				
				System.out.println("DSADSA");
				Clients.set(array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
				Clients.setWalking(array[1], true);
			}
			if (message.trim().substring(0, 2).equalsIgnoreCase("12")) {
				Clients.setWalking(array[1], false);
			}
			if (message.trim().substring(0, 2).equalsIgnoreCase("11")) {
				Clients.setDir(array[1], Integer.parseInt(array[2]));
			}

			if (message.trim().substring(0, 2).equalsIgnoreCase("90")) {
				System.out.println("Server disconnected!");
			}
		}

	}

	public void sendData(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMessage() {
		return message;
	}

}
