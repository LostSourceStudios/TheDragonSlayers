package Main.GUI.Notification;

import java.awt.Graphics;

public class quickNote {

	public String text;
	public int time;
	
	public quickNote(String text) {
		this.text = text;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawString(text, x, y);
	}

	
	
	
	
}
