package Net.Client;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Scanner;

import Flash.Images.FImage;
import FrameWork.Screen;
import Main.Game;
import Main.Mob.Mob;

public class MPplayer extends Mob {

	Image d1;
	Image d2;
	Image d3;
	Image l1;
	Image l2;
	Image l3;
	Image r1;
	Image r2;
	Image r3;
	Image u1;
	Image u2;
	Image u3;
	
	private Image sprite;
	private int anim;
	private boolean walking = false;
	public double health, mana, stamina;
	public long timer = System.currentTimeMillis();
	public double manaRegen = 5.0;
	public double healthRegen = 5.0;
	public double staminaRegen = 5.0;
	public String name;

	public int location;
	Scanner mem = new Scanner(System.in);

	public MPplayer(String name, int x, int y, String ip, int port) {
		super(x, y, Game.level, 0);
		
		sprite = FImage.loadImage("/textures/mobs/" + type + "/Down2.png");
		d1 = FImage.loadImage("/textures/mobs/" + type + "/Down1.png");
		d2 = FImage.loadImage("/textures/mobs/" + type + "/Down2.png");
		d3 = FImage.loadImage("/textures/mobs/" + type + "/Down3.png");
		l1 = FImage.loadImage("/textures/mobs/" + type + "/Left1.png");
		l2 = FImage.loadImage("/textures/mobs/" + type + "/Left2.png");
		l3 = FImage.loadImage("/textures/mobs/" + type + "/Left3.png");
		r1 = FImage.loadImage("/textures/mobs/" + type + "/Right1.png");
		r2 = FImage.loadImage("/textures/mobs/" + type + "/Right2.png");
		r3 = FImage.loadImage("/textures/mobs/" + type + "/Right3.png");
		u1 = FImage.loadImage("/textures/mobs/" + type + "/Up1.png");
		u2 = FImage.loadImage("/textures/mobs/" + type + "/Up2.png");
		u3 = FImage.loadImage("/textures/mobs/" + type + "/Up3.png");
		
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void teleport(int x, int y) {
		this.x = x;
		this.y = y;
	}

	

	int i = 0;
	int j = 0;
	int l = 0;

	public void update() {

		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		manaRegen = 5.0;
		healthRegen = 2.5;

		updateShooting();

		// System.out.println(anim);

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			setWalking(true);
		} else {
			setWalking(false);
		}

	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	

	

	public void render(Screen s, Graphics g) {

		if (dir == 1) {
			if (anim == 1)
				sprite = d1;
			if (anim == 2)
				sprite = d2;
			if (anim == 3)
				sprite = d3;
		}
		if (dir == 3) {
			if (anim == 1)
				sprite = l1;
			if (anim == 2)
				sprite = l2;
			if (anim == 3)
				sprite = l3;
		}
		if (dir == 2) {
			if (anim == 1)
				sprite = r1;
			if (anim == 2)
				sprite = r2;
			if (anim == 3)
				sprite = r3;
		}
		if (dir == 0) {
			if (anim == 1)
				sprite = u1;
			if (anim == 2)
				sprite = u2;
			if (anim == 3)
				sprite = u3;
		}

		s.renderPlayer(g, x, y, sprite);
//		if (!walkingDone)
//			g.drawImage(Game.waypoint, Game.reqX - Game.x, Game.reqY - Game.y - 64, null);


	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	/**
	 * @return the walking
	 */
	public boolean isWalking() {
		return walking;
	}

	/**
	 * @param walking
	 *            the walking to set
	 */
	public void setWalking(boolean walking) {
		this.walking = walking;
	}

}
