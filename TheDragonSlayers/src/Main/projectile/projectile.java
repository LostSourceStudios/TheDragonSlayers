package Main.projectile;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import FrameWork.Screen;
import Main.Game;
import Main.GUI.Target.targetThing;
import Main.Mob.Hitbox;
import Main.Mob.Mob;
import Main.World.LevelHandeler;
import Main.tools.Textures;

import com.lss.flasher.GameObjects.ParticleSpawner;
import com.lss.flasher.GameObjects.ParticleSpawner.type;

public class projectile {

	public static ArrayList<projectile> proj = new ArrayList<projectile>();
	public static int selected;
	
	
	public double x, y;
	public double xOrigin, yOrigin;
	public double xv, yv;
	public double speed = 8;
	public int damage;
	public double range;
	public int fireRate;
	public Image texture;
	public Hitbox box;
	public static Mob firedBy;
	public static Mob targeted;

	public projectile() {
		
	}
	
	
	public static void shootSelected() {
		
	}

	@SuppressWarnings("static-access")
	public projectile(int x, int y, double angle, Image tex, Mob firedBy) {
		this.firedBy = firedBy;
		this.x = x;
		this.y = y;
		xOrigin = x;
		yOrigin = y;
		xv = speed * Math.cos(-angle + 1.5);
		yv = speed * Math.sin(-angle + 1.5);
		texture = tex;
		box = new Hitbox(x, y, 32, 32);
	}

	Mob m;

	public void onCollision() {
		targeted = m;
		m.targetedBy = firedBy;
		// System.out
		// .println("Shooting at: " + targeted + ", " + targeted.hostile);
		if (!targeted.peaceful)
			targeted.health -= damage;
		remove();
	}

	public void targetIsHostile() {
		targeted.targeted = firedBy;
	}

	public void update() {
		
		
		
		
		x += xv;
		y += yv;
		box.set(x, y);
		System.out.println((int) ((x / 64) + Game.x / 64) + ", "+ (int) ((y / 64) + Game.y / 64));

		if (LevelHandeler.getSelectedLevel()
				.getTile((int) ((x / 64) + Game.x / 64), (int) ((y / 64) + Game.y / 64))
				.solid()) {
			remove();
			
			
			
		}

		for (int i = 0; i < LevelHandeler.getSelectedLevel().mobs.size(); i++) {
			m = LevelHandeler.getSelectedLevel().mobs.get(i);
			if (m != firedBy) {
				if (box.collision(m.box)) {
					onCollision();

					if (targeted.health <= 0)
						firedBy.MobKills++;

					if (targeted.hostile)
						targetIsHostile();

					if (firedBy == Game.player)
						targetThing.targeted = targeted;

				}
			}
		}
		if (distance() > range)
			remove();

	

	}

	private void remove() {
		LevelHandeler.getSelectedLevel().projectiles.remove(this);
		ParticleSpawner.spawnParticle((int) ((x)), (int) ((y)), 100, 50, 8, 2, type.EXPLOSION, Textures.fireParticle);

	}

	public double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y)
				* (yOrigin - y)));
		return dist;
	}

	public void render(Screen s, Graphics g) {
		s.renderEntity(g, (int) x, (int) y, 32, 32, texture);

	}

}
