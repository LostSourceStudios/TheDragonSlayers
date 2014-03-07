package Main.GUI.Mouse.option;

import java.awt.Image;

import Main.Game;

public class optClearMob extends options {
	

	public optClearMob(Image icon) {
		super(icon);
	}

	public void ifSelected() {
	
		Game.level.mobs.clear();
		
		
	}

	public void update() {

	}


}
