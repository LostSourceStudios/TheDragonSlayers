package Main.World;

import java.awt.Graphics;
import java.util.ArrayList;

import Main.Game;
import Main.Mob.Mob;
import Main.projectile.projectile;

public class LevelHandeler {

	public static ArrayList<Level> levels = new ArrayList<Level>();

	public static int selectedLevel = 0;

	public static void addMob(Mob m, int levelID) {
		levels.get(levelID).addMob(m);
	}

	public static void addProjectile(projectile p, int levelID) {
		levels.get(levelID).addProjectile(p);
	}

	public static void useLevel(int levelID) {

		getLevel(selectedLevel).mobs.remove(Game.player);


		selectedLevel = levelID;
		Game.player.setLevel(getLevel(selectedLevel));

		getLevel(selectedLevel).addMob(Game.player);
		getSelectedLevel().x = getLevel(levelID).xN;
		getSelectedLevel().y = getLevel(levelID).yN;
	}
	
	public static void teleportToLevel(int levelID, int x, int y) {

		getLevel(selectedLevel).mobs.remove(Game.player);


		selectedLevel = levelID;
		Game.player.setLevel(getLevel(selectedLevel));

		getLevel(selectedLevel).addMob(Game.player);
		getSelectedLevel().x = x * 64;
		getSelectedLevel().y = y * 64;
	}

	public static void addLevel(Level l) {
		levels.add(l);
	}

	public static void update() {
		levels.get(selectedLevel).update();
	}

	public static void render(Graphics g, int xScroll, int yScroll) {
		levels.get(selectedLevel).render(xScroll, yScroll, g);
	}
	
	public static void renderForeground(Graphics g, int xScroll, int yScroll) {
		levels.get(selectedLevel).renderForeground(xScroll, yScroll, g);
	}

	public static Level getLevel(int i) {
		return levels.get(i);
	}

	public static Level getSelectedLevel() {
		return levels.get(selectedLevel);
	}

	public static void renderMobs(Graphics g) {
		for (int i = 0; i < levels.size(); i++) {
			if (i == selectedLevel) {
				levels.get(i).renderMobs(g);
			}
		}
	}

}
