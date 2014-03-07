package Main.GUI.Mouse.option;

import java.awt.Graphics;
import java.awt.Image;

public class options {

	public Image icon;
	public Image back;
	public boolean selected = false;
	
	
	public options(Image icon) {
		this.icon = icon;
	}
	
	public void ifSelected() {
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(icon, x, y, 28, 28, null);
	}
	
}
