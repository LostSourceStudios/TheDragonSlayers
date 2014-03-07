package Main.World;

import java.awt.Graphics;
import java.util.ArrayList;

import FrameWork.Screen;
import Main.World.Tiles.tileGrass;
import Main.World.Tiles.tileHouse;
import Main.World.Tiles.tileLava;
import Main.World.Tiles.tileNormal;
import Main.World.Tiles.tileSand;
import Main.World.Tiles.tileVoid;
import Main.World.Tiles.tileWater;
import Main.tools.Textures;

import com.lss.flasher.Graphics.Sprite;

public class Tile {

	public String name;
	public Sprite texture;
	public int color;
	
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	/*
	 * Register tiles below.
	 */
	public static Tile air = new tileVoid("Air");
	public static Tile grass = new tileGrass("Grass", Textures.grass, 0xFF4CFF00);
	public static Tile sand = new tileSand("Sand", Textures.sand, 0xffFFFF00);
	public static Tile water = new tileWater("Water",Textures.water, 0xff0094FF);
	public static Tile wood1 = new tileNormal("Wood Birch",Textures.wood1, 0xff7F3300);
	public static Tile lava = new tileLava("Lava",Textures.lava, 0xffFF0000);


	
	public static Tile stoneHouseUL = new tileHouse("Stone House Upper Left", Textures.stoneHouseUL, 0xff202020);
	public static Tile stoneHouseUR = new tileHouse("Stone House Upper Right", Textures.stoneHouseUR, 0xff303030);
	public static Tile stoneHouseDL = new tileHouse("Stone House Down Left", Textures.stoneHouseDL, 0xff404040);
	public static Tile stoneHouseDR = new tileHouse("Stone House Down Right", Textures.stoneHouseDR, 0xff505050);

	public static Tile stoneHouseUW = new tileHouse("Stone House Upper Wall", Textures.stoneHouseUW, 0xff606060);
	public static Tile stoneHouseDW = new tileHouse("Stone House Down Wall", Textures.stoneHouseDW, 0xff101010);
	public static Tile stoneHouseLW = new tileHouse("Stone House Left Wall", Textures.stoneHouseLW, 0xff707070);
	public static Tile stoneHouseRW = new tileHouse("Stone House Right Wall", Textures.stoneHouseRW, 0xff808080);
	
	
	
	public static Tile door1 = new tileHouse("Door One", Textures.door1, 0xff331300);

	
	/*
	 * Water is the original tile. Water1 however is the animation tile,
	 * change the location and ever second or so it will update the animation - Jacob
	 */
	
	


	
	public Tile(String n, Sprite sprite, int color) {
		texture = sprite;
		this.name = n;
		this.color = color;
		tiles.add(this);
	}
	
	public Tile(String n) {
		this.name = n;
	}
	
	public Tile() {
		
	}
	
	public Tile(Sprite sprite) {
		this.texture = sprite;
	}
	
	public boolean solid() {
		return false;
	}
	
	
	public void render(Graphics g, Screen s) {
		
	}
	
	public void render(int x, int y,Graphics g, Screen s, boolean b) {
		
	}
	
	
	
}
