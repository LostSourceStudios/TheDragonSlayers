package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.FButton;
import Flash.Images.FImage;
import Main.Start.State;

public class deadMenu {
	
	Image img;
	
	//215,65
	
	public deadMenu() {
		img = FImage.loadImage("/textures/menu.png");
		FButton.addButton(215, 65, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Play", false);
		FButton.addButton(215, 226, 1064 - 215, 184 - 65, Color.LIGHT_GRAY, Color.GRAY, "Menu", false);


	}

	public void update() {
		if (FButton.mouseCheckLeft("Play")) {
			Start.state = State.GAME;
			Game.player.respawn();
		}
		if (FButton.mouseCheckLeft("Menu")) {
			Start.state = State.MENU;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(img, 0, 0, null);
		FButton.render(g);
	}
	
}
