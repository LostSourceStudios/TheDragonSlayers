package Main.Mob;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Hitbox {

	public double x, y, width, height;
	public Rectangle r;

	public Hitbox(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		r = new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public boolean collision(Hitbox b) {
		if (r.intersects(b.r))
			return true;
		else
			return false;
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
		r.setBounds((int) x, (int) y, (int) width, (int) height);
	}

	public void render(Graphics g) {
		g.drawRect((int) x, (int) y, (int) width, (int) height);
	}

}
