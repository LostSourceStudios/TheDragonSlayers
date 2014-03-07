package Main.Mob.Spawner;

import java.util.Random;

import Main.Mob.Mob;
import Main.Mob.dragons.dragonBaby;
import Main.World.Level;

public class WorldSpawner {

	public static Random r = new Random();

	int i = 0;

	int x, y;

	Level level;

	public WorldSpawner(Level l) {
		level = l;
	}

	public void update() {
		i++;

		if (i > 7) {
			i = 0;

			x = r.nextInt(level.width * 64);
			y = r.nextInt(level.height * 64);
			if (!level.getTile(x / 64, y / 64).solid()) {


				Mob m = new dragonBaby(x, y, level, 4);
				level.addMob(m);

			}
		}
	}
}
