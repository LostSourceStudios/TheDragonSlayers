package Main.projectile;

import java.awt.Image;

import Flash.Images.FImage;
import Main.Mob.Mob;

public class proFire extends projectile {

	public static Image texture = FImage.loadImage("/textures/projectiles/fireSpell.png");

	public proFire(int x, int y, double angle, Mob f) {
		super(x, y, angle, texture, f);
		range = 300;
		damage = 5;
	}

	public proFire(Image texture) {

	}

}
