package Main.GUI.Mouse.option;

import java.awt.Image;

import Main.Game;

public class optWalkThere extends options {
	

	public optWalkThere(Image icon) {
		super(icon);
	}

	public void ifSelected() {
		Game.reqY = FastOption.y + Game.y - 32;
		Game.reqX = FastOption.x + Game.x - 32;
	}

	public void update() {

	}


}
