package Main.World.Tiles;

import java.awt.Graphics;

import FrameWork.Screen;
import Main.World.Tile;

import com.lss.flasher.Graphics.Sprite;

public class tileHouse extends Tile {

	public tileHouse(String n, Sprite sprite, int color) {
		super(n, sprite, color);
	}
	
	

	@Override
	public void render(int x, int y, Graphics g, Screen s, boolean b) {
		s.renderTile(x, y, this.texture, g, b);
	}
	
	public boolean solid() {
		return true;
	}

}
