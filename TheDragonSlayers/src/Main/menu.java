package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.FButton;
import Flash.Images.FImage;
import Main.Start.State;

public class menu {
	
	Image img;
	
	//215,65
	
	public menu() {
		img = FImage.loadImage("/textures/menu.png");
		FButton.addButton(215, 65, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Play", false);
		FButton.addButton(215, 226, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Settings", false);
		FButton.addButton(215, 390, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Multiplayer", false);
		FButton.addButton(215, 552, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Exit", false);

	}

	public void update() {
		if (FButton.mouseCheckLeft("Play")) {
			Start.state = State.GAME;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(img, 0, 0, null);
		FButton.render(g);
	}
	
}
