package Main.Mob.dragons;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import Flash.Graphics.Animation.Animation;
import Flash.Images.FImage;
import FrameWork.Screen;
import Main.Game;
import Main.Mob.Hitbox;
import Main.Mob.Mob;
import Main.World.Level;
import Main.projectile.proFire;

public class dragonBaby extends Mob {

	public Random r;
	public Animation a;
	int anim;

	Image d1;
	Image d2;
	Image d3;
	Image d4;

	Image l1;
	Image l2;
	Image l3;
	Image l4;

	Image r1;
	Image r2;
	Image r3;
	Image r4;

	Image u1;
	Image u2;
	Image u3;
	Image u4;

	public dragonBaby(int x, int y, Level l, int id) {
		super(x, y, l, id);

		type = "dragonBaby";

		spriteSizeX = 96;
		spriteSizeY = 96;
		xMod = 0;
		yMod = 0;

		hostile = true;
		peaceful = false;
		speed = 4;

		sprite = FImage.loadImage("/textures/mobs/" + type + "/Down2.png");
		icon = FImage.loadImage("/textures/mobs/" + type + "/icon.png");

		d1 = FImage.loadImage("/textures/mobs/" + type + "/Down1.png");
		d2 = FImage.loadImage("/textures/mobs/" + type + "/Down2.png");
		d3 = FImage.loadImage("/textures/mobs/" + type + "/Down3.png");
		d4 = FImage.loadImage("/textures/mobs/" + type + "/Down4.png");

		l1 = FImage.loadImage("/textures/mobs/" + type + "/Left1.png");
		l2 = FImage.loadImage("/textures/mobs/" + type + "/Left2.png");
		l3 = FImage.loadImage("/textures/mobs/" + type + "/Left3.png");
		l4 = FImage.loadImage("/textures/mobs/" + type + "/Left4.png");

		r1 = FImage.loadImage("/textures/mobs/" + type + "/Right1.png");
		r2 = FImage.loadImage("/textures/mobs/" + type + "/Right2.png");
		r3 = FImage.loadImage("/textures/mobs/" + type + "/Right3.png");
		r4 = FImage.loadImage("/textures/mobs/" + type + "/Right4.png");

		u1 = FImage.loadImage("/textures/mobs/" + type + "/Up1.png");
		u2 = FImage.loadImage("/textures/mobs/" + type + "/Up2.png");
		u3 = FImage.loadImage("/textures/mobs/" + type + "/Up3.png");
		u4 = FImage.loadImage("/textures/mobs/" + type + "/Up4.png");

		speed = 3;
		r = new Random();
		box = new Hitbox(x, y, 96, 96);

		xpToGive = 8;

	}

	int xa, ya;
	int i = 1;
	int j = 0;
	int rand = 5;

	public void update() {
		if (j > 20) {
			rand = r.nextInt(10);
			j = 0;

		}
		j++;
		if (targeted != null) {
			if (j > 20) {
				rand = r.nextInt(10);
				j = 0;
				if (getRange(targeted) < 300)shoot(new proFire(x - Game.x + 28, y - Game.y + 28, getAngle(targeted.x, targeted.y), this));
			}
			j++;

			if (getRange(targeted) > 100){
				if (targeted.x < x)
					xa -= speed;
				if (targeted.x > x)
					xa += speed;
				if (targeted.y < y)
					ya -= speed;
				if (targeted.y > y)
					ya += speed;
			}
			
			if (getRange(targeted) > 500)if (rand == 4) targeted = null;

		} else {


			if (rand == 0)
				xa = speed;
			if (rand == 1)
				xa = -speed;
			if (rand == 2)
				ya = speed;
			if (rand == 3)
				ya = -speed;
		}

		if (health <= 0)
			ifKilled();

		box.set(x - Game.x, y - Game.y);

		if (i > 8) {
			if (anim < 4) {
				anim++;
			} else
				anim = 1;
			i = 0;
		}
		i++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;
			anim = 2;
			i = 0;
		}

		ya = 0;
		xa = 0;

	}

	public void render(Screen s, Graphics g) {
		if (dir == 1) {
			if (anim == 1)
				sprite = d1;
			if (anim == 2)
				sprite = d2;
			if (anim == 3)
				sprite = d3;
			if (anim == 4)
				sprite = d4;
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

		s.renderMob(g, x, y, 96, 96, sprite);
//		 box.render(g);

	}

}
