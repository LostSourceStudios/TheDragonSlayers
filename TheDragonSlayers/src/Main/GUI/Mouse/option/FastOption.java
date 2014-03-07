package Main.GUI.Mouse.option;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.FFunc;
import Flash.Button.Mouse;
import Flash.Images.FImage;

import com.lss.flasher.Input.Keyboard;

public class FastOption {

	public Image texture;
	public Image selector;
	public boolean active = false;
	@SuppressWarnings("unused")
	private Keyboard k;
	public options[] o;
	public static int x, y;

	public FastOption(options[] o, Keyboard key) {
		k = key;
		this.o = o;
		texture = FImage.loadImage("/textures/fastOptions.png");
		selector = FImage.loadImage("/textures/selector.png");
	}



	public void render(Graphics g) {
		if (active) {
			g.drawImage(texture, x - 64, y - 64, 128, 128, null);
			g.setColor(new Color(105, 94, 57));
			g.drawLine(x, y, Mouse.mouseX, Mouse.mouseY);
			g.drawImage(selector, Mouse.mouseX - 8, Mouse.mouseY - 8, 16, 16, null);
			for (int i = 0; i < o.length; i++) {
				if (i == 0 && o[i] != null) {
					o[i].render(g, x - 13, y - 61);
				}
				if (i == 1 && o[i] != null) {
					o[i].render(g, x + 34, y - 13);
				}
				if (i == 2 && o[i] != null) {
					o[i].render(g, x - 13, y + 35);
				}
				if (i == 3 && o[i] != null) {
					o[i].render(g, x - 61, y - 13);
				}
			}
		}

	}

	@SuppressWarnings("static-access")
	public float getAngle(float x, float y) {
		return (float) Math.toDegrees(Math.atan2(x - this.x, y - this.y));
	}
	
	public boolean hasMouseBeenDown = false;

	public void update() {
			if (FFunc.mouseCheckRight(0, 0, 1280, 700)) {
				active = true;
				
			} else {
				if (active) {
					float angle = getAngle((float) Mouse.mouseX, (float) Mouse.mouseY);
					
						if (angle < 180 && angle > 135 || angle > -180 && angle < -135) {
//							System.out.println("Nr 1");
							if (o[0] != null) {
								o[0].ifSelected();
							}
						}
						if (angle < 135 && angle > 45) {
//							System.out.println("Nr 2");
							if (o[1] != null) {
								o[1].ifSelected();
							}
						}
						if (angle < 45 && angle > -45) {
//							System.out.println("Nr 3");
							if (o[2] != null) {
								o[2].ifSelected();
							}
						}
						if (angle < -45 && angle > -135) {
//							System.out.println("Nr 4");
							if (o[3] != null) {
								o[3].ifSelected();
							}
						}
					
				}
				active = false;
				x = Mouse.mouseX;
				y = Mouse.mouseY;
				
			}
	}

}
