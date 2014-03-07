package Main.GUI.Notification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class notificationHandeler {

	public static ArrayList<quickNote> notes = new ArrayList<quickNote>();

	public static void addNote(String text) {
		notes.add(new quickNote(text));
	}

	public static void update() {
		for (int i = 0; i < notes.size(); i++) {
			notes.get(i).time++;
			if (notes.get(i).time > 240)
				notes.remove(i);
			
			if (notes.size() >10) {
				notes.remove(0);
			}
			
		}
	}

	public static void render(Graphics g) {
		for (int i = 0; i < notes.size(); i++) {
			g.setFont(new Font("Arial", 1, 15));
			g.setColor(new Color(250, 200, 0));
			notes.get(i).render(g, 250, 50 + (15 * i));
		}
	}

}
