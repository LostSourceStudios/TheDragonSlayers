package Main.World;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Main.Game;

public class Teleporter {

	int x, y;
	int targetX, targetY;
	int levelID;
	int cLevel;

	boolean requestTP = false;

	public Teleporter(int x, int y, int tx, int ty, int lvlID, int currentLevel) {
		this.x = x;
		this.y = y;
		targetX = tx;
		targetY = ty;
		levelID = lvlID;
		cLevel = currentLevel;
	}

	public static ArrayList<Teleporter> teleporters = new ArrayList<Teleporter>();

	public static void addTeleporter(int x, int y, int tx, int ty, int levelID,
			int currentLevel) {
		teleporters.add(new Teleporter(x, y, tx, ty, levelID, currentLevel));
	}

	public static void update() {
		for (int i = 0; i < teleporters.size(); i++) {
			teleporters.get(i).updateSpecific();
		}
	}

	public static void render(Graphics g) {
		for (int i = 0; i < teleporters.size(); i++) {
			teleporters.get(i).renderPrivate(g);
		}
	}

	private void renderPrivate(Graphics g) {
		if (LevelHandeler.selectedLevel == cLevel)
			if (requestTP) {
				g.setFont(new Font("Arial", 1, 30));
				g.setColor(Color.white);
				g.drawString("Press [SPACE] to use", (1280 / 2)
						- ("Press [SPACE] to use".length() * 8), 55);
			}
	}

	boolean toggle = false;
	boolean shouldTP = false;

	private void updateSpecific() {

		if (LevelHandeler.selectedLevel == cLevel)
			if (Game.player.x / 64 == x && Game.player.y / 64 == y) {
				requestTP = true;
			} else {
				requestTP = false;
			}

		if ((Game.key.key.get(13)) && !toggle) {

			if (LevelHandeler.selectedLevel == cLevel)
				if ((Game.player.x + 32) / 64 == x
						&& (Game.player.y + 32) / 64 == y) {

					requestTP = false;
					LevelHandeler.teleportToLevel(levelID, targetX, targetY);

				}

			toggle = true;
		} else if (!(Game.key.key.get(13)))
			toggle = false;

	}

}
