package Menu.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Flash.Button.FFunc;

public class Character {

	public String name;
	public String g_class;
	public int team;
	int x, y, xa, ya;
	public int level = 1;

	public boolean isMouseOver = false;
	public boolean isSelected = false;
	public boolean isPressed = false;
	public boolean isEmpty = true;

	public Character(String name, String game_class, int team, int xx, int yy, int xxa, int yya, int level) {

		if (!name.equalsIgnoreCase("Empty")) {
			isEmpty = false;
		}

		this.level = level;
		
		this.name = name;
		this.g_class = game_class;
		this.team = team;

		x = xx;
		y = yy;
		xa = xxa;
		ya = yya;

	}

	public void update() {
		if (FFunc.mouseCheckPos(x, y, xa, ya)) {
			isMouseOver = true;
		} else {
			isMouseOver = false;
		}

		isPressed = FFunc.mouseCheckLeft(x, y, xa, ya);
	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect(x, y, xa, ya);

		if (isEmpty) {
			g.setFont(new Font("Arial", 1, 30));
			g.setColor(Color.white);
			g.drawString("Empty", x + 20, y + 55);
		} else {
			g.setFont(new Font("Arial", 1, 20));
			g.setColor(Color.white);
			g.drawString(name, x + 20, y + 30);
			g.setFont(new Font("Arial", 1, 10));
			g.drawString("Level " + level + " " + g_class, x + 20, y + 45);
		}

		if (isSelected) {
			g.drawImage(CharSelect.marker, x, y, xa, ya, null);
		}

	}

}
