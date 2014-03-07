package Main.Mob.Spawner;

import java.util.ArrayList;

import Main.Game;
import Main.Mob.Mob;
import Main.Mob.dragons.dragonBaby;

public class Spawner {

	int x, y, a, r;
	String m;
	int time;

	public static ArrayList<Spawner> spawners = new ArrayList<Spawner>();

	public static void addSpawner(int x, int y, int amount, int ratio, int time, String m) {
		Spawner s = new Spawner(x, y, amount, ratio, time, m);
		spawners.add(s);
	}

	public static void updateAll() {
		for (int i = 0; i < spawners.size(); i++) {
			spawners.get(i).update();
		}
	}
	int i = 0;
	int j = 0;
	public void update() {
		i++;
		if (i > r) {
			i = 0;
			if (m == "dragonBaby") {
				Mob ma = new dragonBaby(x,y,Game.level,6564);
				Game.level.addMob(ma);
				j++;
			}
		}
		if (j > a - 1) spawners.remove(this);

	}
	
	public Spawner(int x, int y, int amount, int ratio, int time, String m) {
		this.x = x;
		this.y = y;
		a = amount;
		r = ratio;
		this.m = m;
		this.time = time;
	}

}
