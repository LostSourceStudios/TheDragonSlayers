package Main.Mob;

import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.Mouse;
import FrameWork.Screen;
import Main.Game;
import Main.World.Level;
import Main.World.LevelHandeler;
import Main.projectile.proFire;
import Main.projectile.projectile;

import com.lss.flasher.Input.Keyboard;

public class Mob {

	// Mob options:
	public boolean hostile = false; // If the mob should damage the player.
	public boolean peaceful = true; // If you can harm the mob.
	public boolean boss = false; // If its a boss.
	public int speed = 2; // The speed in pixels.
	public double health = 100.0; // The mob health.
	public double maxHealth = 100.0; // The mob max health.
	public double healthRegen = 2.0; // The amount of health the mob should regen per sec.
	public int lvl = 0;
	public int gold = 0;
	public String type; // The kind of mob, used for texture path and targeting.
	public double xp; // Experience.
	public boolean isTalking; // If the mob is talking to another.
	public Mob talkingTo; // The mob that this mob is talking to.
	public Mob targetedBy;
	public Mob latestKill;
	public int MobKills = 0; // Kills.

	public boolean dead = false;
	public Mob targeted;

	public int spriteSizeX, spriteSizeY, xMod, yMod;

	public int x, y;
	public int xa, ya;
	public Keyboard key;
	public Image sprite;
	public Image icon;
	public boolean moving = false;
	public int dir = 0;
	public Hitbox box;
	public Level level;
	public int id;
	public boolean shoot = false;
	public projectile selectedProjectile;
	public Mob fireOn;
	public int maxXP;
	public int xpToGive = 5;

	//
	
	public void ifKilled() {
		remove();
		targetedBy.xp += this.xpToGive;
		targetedBy.latestKill = this;
	}
	
	
	
	
	
	
	
	
	//
	public Mob(int x, int y, Keyboard key, Level l) {
		this.x = x;
		this.y = y;
		this.key = key;
		level = l;
	}

	public Mob(int x, int y, Level l, int id) {
		this.x = x;
		this.y = y;
		level = l;
		this.id = id;
	}

	public double getRange(Mob m) {
		double dist = 0;
		dist = Math.sqrt(Math.abs((m.x - x) * (m.x - x) + (m.y - y) * (m.y - y)));
		return dist;
	}

	public float getAngle(float x, float y) {
		return (float) Math.atan2(x - this.x, y - this.y);
	}

	public void updateShooting() {
		if (shoot) {
			projectile p = new proFire(x - Game.x + 28, y - Game.y + 28, getAngle((float) Mouse.mouseX - 32 + Game.x, (float) Mouse.mouseY - 32 + Game.y), this);
			level.projectiles.add(p);
			shoot = false;
		}
	}

	public void shoot(projectile p) {
		level.addProjectile(p);
	}

	public void update() {

	}

	public void remove() {
		level.mobs.remove(this);
	}

	public void move(int xv, int yv) {

		xa = xv;
		ya = yv;
		
		if (xv > 0)
			dir = 2;
		if (xv < 0)
			dir = 3;
		if (yv > 0)
			dir = 1;
		if (yv < 0)
			dir = 0;

		if (!collision(xv, 0)) {
			if (xv > 0) {
				x += xv;
			}
			if (xv < 0) {
				x += xv;
			}
		}
		if (!collision(0, yv)) {
			if (yv > 0) {
				y += yv;
			}
			if (yv < 0) {
				y += yv;
			}
		}
	}
	
	public void movePlayer(int xv, int yv) {

		xa = xv;
		ya = yv;
		
		if (xv > 0)
			dir = 2;
		if (xv < 0)
			dir = 3;
		if (yv > 0)
			dir = 1;
		if (yv < 0)
			dir = 0;

		if (!collision(xv, 0)) {
			if (xv > 0) {
				LevelHandeler.getSelectedLevel().x += xv;
			}
			if (xv < 0) {
				LevelHandeler.getSelectedLevel().x += xv;
			}
		}
		if (!collision(0, yv)) {
			if (yv > 0) {
				LevelHandeler.getSelectedLevel().y += yv;
			}
			if (yv < 0) {
				LevelHandeler.getSelectedLevel().y += yv;
			}
		}
	}

	public void render(Screen s, Graphics g) {

	}

	public boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * spriteSizeX + xMod) / 64;
			int yt = ((y + ya) + c / 2 * spriteSizeY - yMod) / 64;
			if (level.getTile(xt, yt).solid())
				solid = true;

		}

		return solid;
	}

	public void respawn() {
	}

	public void isTalkingTo(boolean b) {
		if (b) {
			Game.player.talkingTo = this;
			System.out.println(this);
		} else {
			Game.player.talkingTo = null;
		}
	}








	public void setLevel(Level level2) {
		
	}

}
