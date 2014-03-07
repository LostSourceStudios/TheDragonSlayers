package Net.Client;

import java.awt.Graphics;
import java.util.ArrayList;

import FrameWork.Screen;

public class Clients extends Thread {

	public static ArrayList<MPplayer> players = new ArrayList<MPplayer>();

	public static void addPlayer(int x, int y, String name, String ip, int port) {
		try {
			MPplayer p = new MPplayer(name, x, y, ip, port);
			System.out.println("Player: " + name + " has joined the game!");
			players.add(p);
		} catch (Exception e) {
			System.out.println("Could not add player: " + name);
		}
	}

	public static void removePlayer(int PlayerIndex) {
		try {
			players.remove(PlayerIndex);
		} catch (Exception e) {
			System.out.println("Could not find player id: " + PlayerIndex);
		}
	}
	
	public static void set(String name, int x, int y) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().trim().equalsIgnoreCase(name)) {
				players.get(i).setX(x);
				players.get(i).setY(y);
			}
		}
	}

	public static void removePlayer(String name) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().trim().equalsIgnoreCase(name)) {
				System.out.println("Player: " + name + " disconnected!");
				removePlayer(i);
			}
		}
	}

	public static void render(Screen screen, Graphics g) {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(screen, g);
		}

	}
	
	public static void update() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).update();
		}
	}

	public static void setDir(String name, int dir) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().trim().equalsIgnoreCase(name)) {
				players.get(i).setDir(dir);
			}
		}
	}

	public static void setWalking(String string, boolean b) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().trim().equalsIgnoreCase(string)) {
				players.get(i).setWalking(b);
			}
		}
	}

}
