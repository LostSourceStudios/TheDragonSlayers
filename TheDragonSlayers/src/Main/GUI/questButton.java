package Main.GUI;

import java.awt.Color;
import java.awt.Image;

import Flash.Button.FFunc;
import Main.quest.Quest;

public class questButton {

	int x;
	int y;
	int xo;
	int yo;
	int xa;
	int ya;
	Color col1;
	Color col2;
	String name;
	boolean active = true;
	boolean toggle;
	boolean canToggle;
	boolean tempT;
	boolean visible = true;
	public Image texture;
	public Image texture2;
	boolean isPressed = false;

	public Quest quest;
	public boolean showToolTip = false;

	public questButton(int x, int y, int xa, int ya, Color col1, Color col2, String name, boolean canToggle) {
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
		this.col1 = col1;
		this.col2 = col2;
		this.name = name;
		this.canToggle = canToggle;
	}



	public void update(int xo, int yo) {
		
		if (FFunc.mouseCheckLeft(x + xo, y + yo, xa, ya)) {
			isPressed = true;
		} else {
			isPressed = false;
		}
		
		if (quest != null)
			if (FFunc.mouseCheckLeft(x + xo, y + yo, xa, ya)) {
				quest.isSelected();
			}
		if (FFunc.mouseCheckPos(x + xo, y + yo, xa, ya)) {
			showToolTip = true;
		} else {
			showToolTip = false;
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXA() {
		return xa;
	}

	public int getYA() {
		return ya;
	}

	public Color getCol1() {
		return col1;
	}

	public Color getCol2() {
		return col2;
	}

	public String getName() {
		return name;
	}

	public void setOffset(int x2, int y2) {
		xo += x2;
		yo += y2;
	}

}
