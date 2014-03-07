package Menu.Loading;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Images.FImage;
import Main.Start;
import Main.Start.State;
import Menu.Character.CharSelect;
import Net.MySQL.connect;

public class Loading implements Runnable {

	public static int done = 0;
	public Image bi = FImage.loadImage("/textures/Backgrounds/BI.png");

	public Thread t;
	
	public Loading() {
		t = new Thread(this);
	}

	public void update() {
		if (done >= 100) {
			Start.state = State.SELECT;
			done = 0;
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Start.width, Start.height);

		g.setColor(Color.BLACK);
		g.fillRect((Start.width / 2) - 201, 499, 402, 22);

		g.setColor(Color.green);
		g.fillRect((Start.width / 2) - 200, 500, done * 4, 20);

		g.drawImage(bi, 60, 570, 75, 75, null);
	
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", 1, 20));
		g.drawString("Bon Ink Creations", 20, 665);
		
	}

	public static String char1id, char2id, char3id, char4id;
	
	@Override
	public void run() {

		
		
		
		System.out.println("[LOADING] Loding started!");

		Start.PLAYER_NAME = connect.getData("username", Start.login_name, "auth", "accounts");
		done = 5;
		Start.PLAYER_EMAIL = connect.getData("email", Start.login_name, "auth", "accounts");
		done = 10;
		Start.PLAYER_ID = Integer.parseInt(connect.getData("id", Start.login_name, "auth", "accounts"));
		done = 15;

		
		char1id = connect.getLoadingData("char0", "username", Start.login_name, "auth", "accounts");
		
		done = 20;
		char2id = connect.getLoadingData("char1", "username", Start.login_name, "auth", "accounts");
		
		done = 22;
		char3id = connect.getLoadingData("char2", "username", Start.login_name, "auth", "accounts");
		
		done = 24;
		char4id = connect.getLoadingData("char3", "username", Start.login_name, "auth", "accounts");
		
		done = 26;

		
		
		if (!(Integer.parseInt(char1id) == 0)) {
			String char1name = connect.getLoadingData("name", "guid", char1id, "characters", "characters");
			done = 30;
			String char1class = connect.getLoadingData("class", "guid", char1id, "characters", "characters");
			int char1lvl = Integer.parseInt(connect.getLoadingData("level", "charid", char1id, "characters", "stats"));

			done = 40;
			CharSelect.addChar(char1name, char1class, 0, char1lvl);
			done = 42;
		} else {
			CharSelect.addChar("Empty", "", 0,0);
		}

		if (!(Integer.parseInt(char2id) == 0)) {
			String char2name = connect.getLoadingData("name", "guid", char2id, "characters", "characters");
			done = 46;
			String char2class = connect.getLoadingData("class", "guid", char2id, "characters", "characters");
			int char2lvl = Integer.parseInt(connect.getLoadingData("level", "charid", char1id, "characters", "stats"));

			done = 48;
			CharSelect.addChar(char2name, char2class, 0, char2lvl);
			done = 50;
		} else {
			CharSelect.addChar("Empty", "", 0,0);
		}

		if (!(Integer.parseInt(char3id) == 0)) {
			String char3name = connect.getLoadingData("name", "guid", char3id, "characters", "characters");
			done = 54;
			String char3class = connect.getLoadingData("class", "guid", char3id, "characters", "characters");
			int char3lvl = Integer.parseInt(connect.getLoadingData("level", "charid", char1id, "characters", "stats"));

			done = 56;
			CharSelect.addChar(char3name, char3class, 0, char3lvl);
			done = 65;
		} else {
			CharSelect.addChar("Empty", "", 0,0);
		}

		if (!(Integer.parseInt(char4id) == 0)) {
			String char4name = connect.getLoadingData("name", "guid", char4id, "characters", "characters");
			done = 88;
			String char4class = connect.getLoadingData("class", "guid", char4id, "characters", "characters");
			int char4lvl = Integer.parseInt(connect.getLoadingData("level", "charid", char1id, "characters", "stats"));

			done = 96;
			CharSelect.addChar(char4name, char4class, 0, char4lvl);
			done = 100;
		} else {
			CharSelect.addChar("Empty", "", 0,0);
			
		}

		done = 100;
		
		System.out.println("[LOADING] Loding done!");
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
