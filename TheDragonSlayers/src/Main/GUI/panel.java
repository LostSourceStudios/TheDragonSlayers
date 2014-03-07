package Main.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Flash.Button.FFunc;
import Flash.Button.Mouse;
import Flash.Images.FImage;
import Main.Game;

public class panel {

	public int x, y, xa, ya;
	public String name;
	public Image texture;
	public ArrayList<questButton> buttons = new ArrayList<questButton>();

	public panel(String path, String n, int x, int y, int width, int height) {
		name = n;
		this.x = x;
		this.y = y;
		xa = width;
		ya = height;
		texture = FImage.loadImage(path);
	}

	public panel(String n, int x, int y, int width, int height) {
		name = n;
		this.x = x;
		this.y = y;
		xa = width;
		ya = height;
	}

	public void update() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).update(xo, yo);
		}
	}

	public questButton getButtonByName(String name) {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).name.equals(name)) {
				return buttons.get(i);
			}
		}
		return null;
	}
	
	int xo, yo;
	boolean draw = false;
	questButton drawWith = null;

	public void render(Graphics g, int xOffset, int yOffset) {
		xo = xOffset + this.x;
		yo = yOffset + this.y;

		if (texture != null)
			g.drawImage(texture, xo, yo, xa, ya, null);
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).texture2 != null) {

				if (FFunc.mouseCheckPos(buttons.get(i).getX() + xo, buttons.get(i).getY() + yo, buttons.get(i).getXA(), buttons.get(i).getYA())) {

					g.drawImage(buttons.get(i).texture2, buttons.get(i).getX() + xo, buttons.get(i).getY() + yo, buttons.get(i).getXA(), buttons.get(i).getYA(), null);
				} else {
					g.drawImage(buttons.get(i).texture, buttons.get(i).getX() + xo, buttons.get(i).getY() + yo, buttons.get(i).getXA(), buttons.get(i).getYA(), null);
				}
			} else {
				g.drawImage(buttons.get(i).texture, buttons.get(i).getX() + xo, buttons.get(i).getY() + yo, buttons.get(i).getXA(), buttons.get(i).getYA(), null);

			}

			g.setFont(new Font("Verdana", 1, 10));
			g.setColor(Color.black);
			if (buttons.get(i).quest != null) {
				g.drawString(buttons.get(i).quest.name, buttons.get(i).getX() + xo + 48, buttons.get(i).getY() + yo + 15);
				g.drawString("xp: " + buttons.get(i).quest.xpReward, buttons.get(i).getX() + xo + 48, buttons.get(i).getY() + yo + 25);
				g.drawImage(buttons.get(i).quest.icon, buttons.get(i).getX() + xo + 5, buttons.get(i).getY() + yo + 5, 37, 36, null);
				if (buttons.get(i).showToolTip) {
					drawWith = buttons.get(i);
				} else {
					drawWith = null;
				}

			} else {

			}
		}

		if (drawWith != null) {
			if (drawWith.quest != null) {
				g.drawImage(Game.toolTip, Mouse.mouseX + 25, Mouse.mouseY, 128, 64, null);
				g.drawString(drawWith.quest.desc1, Mouse.mouseX + 25, Mouse.mouseY + 10);
				g.drawString(drawWith.quest.desc2, Mouse.mouseX + 25, Mouse.mouseY + 22);
				g.drawString(drawWith.quest.desc3, Mouse.mouseX + 25, Mouse.mouseY + 34);

			}
		}
	}

}
