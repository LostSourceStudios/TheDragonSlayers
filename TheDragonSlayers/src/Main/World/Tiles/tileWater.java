package Main.World.Tiles;

import java.awt.Graphics;

import FrameWork.Screen;
import Main.World.Tile;
import Main.tools.Textures;

import com.lss.flasher.Graphics.Sprite;

public class tileWater extends Tile {
	
	int anim = 0;
	int ss = -1;

	public tileWater(String n, Sprite sprite, int color) {
		super(n, sprite, color);
	}
	
	public void render(int x, int y, Graphics g, Screen s, boolean b) {
		anim++;
		if(anim % 30000 == 0) {
			ss *= -1;
		}
		
		if(ss == -1) s.renderTile(x, y, this.texture, g, b);
		if(ss == 1) s.renderTile(x, y, Textures.water1, g,b);
	}

}
