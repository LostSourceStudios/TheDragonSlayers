package Main.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Flash.Button.FButtonList;
import Flash.Button.FFunc;
import Flash.Button.Mouse;
import Flash.Images.FImage;
import Main.Game;

public class GUI {

	public String name; // Name lol :P
	public boolean canMove = true; // If it can be move
	public int x, y, width, height; // Gui Dimensions
	public Image texture; // The texture of the gui
	public ArrayList<FButtonList> buttons = new ArrayList<FButtonList>();
	public ArrayList<panel> panels = new ArrayList<panel>();

	public boolean show = true;

	public GUI(String name, String path, int x, int y, int xa, int ya) {
		this.x = x;
		this.y = y;
		this.width = xa;
		this.height = ya;
		this.name = name;
		texture = FImage.loadImage(path);
	}

	public panel getPanel(String name) {
		for (int i = 0; i < panels.size(); i++) {
			if (panels.get(i).name.equals(name)) {
				return panels.get(i);
			}
		}
		return null;
	}

	public void addButton(String name, int x, int y, int xa, int ya) {
		FButtonList b = new FButtonList(x, y, xa, ya, Color.LIGHT_GRAY, Color.gray, name, false);
		buttons.add(b);
	}

	public void addQuestButtonToPanel(String path, String panelName, String name, int x, int y, int xa, int ya) {
		if (GUIHandeler.getPanelByName(panelName).name.equals(panelName)) {
			questButton b = new questButton(x, y, xa, ya, Color.LIGHT_GRAY, Color.gray, name, false);
			b.texture = FImage.loadImage(path);
			GUIHandeler.getPanelByName(panelName).buttons.add(b);
		}
	}

	public void addQuestButtonToPanel(String path, String path2, String panelName, String name, int x, int y, int xa, int ya) {
		if (GUIHandeler.getPanelByName(panelName).name.equals(panelName)) {
			questButton b = new questButton(x, y, xa, ya, Color.LIGHT_GRAY, Color.gray, name, false);
			b.texture = FImage.loadImage(path);
			b.texture2 = FImage.loadImage(path2);
			GUIHandeler.getPanelByName(panelName).buttons.add(b);
		}
	}

	public void addPanel(String path, String name, int x, int y, int xa, int ya) {
		panel p = new panel(path, name, x, y, xa, ya);
		panels.add(p);
	}

	public void addPanel(String name, int x, int y, int xa, int ya) {
		panel p = new panel(name, x, y, xa, ya);
		panels.add(p);
	}

	public FButtonList getButton(String name) {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).getName().equals(name)) {
				return buttons.get(i);
			}
		}
		return null;
	}

	public void setCanMove(boolean b) {
		canMove = b;
	}

	boolean b = false;
	int xx, yy;
	public static boolean a = false;

	public void update() {
		
		if (show) {
			for (int i = 0; i < panels.size(); i++) {
				panels.get(i).update();
			}
		}
		
		if (canMove && show) {
			
			if (FFunc.mouseCheckLeft(x, y, width, height)) {
				Game.pressingOnGui = true;
				a = true;
				if (!b) {
					b = true;
					xx = Mouse.mouseX - x;
					yy = Mouse.mouseY - y;
				}

				x = Mouse.mouseX - xx;
				y = Mouse.mouseY - yy;

			} else {
				b = false;
				if (!a)
					Game.pressingOnGui = false;
			}

		} else {
			if (FFunc.mouseCheckLeft(x, y, width, height)) {
				Game.pressingOnGui = true;
				a = true;
			} else {

				if (!a)
					Game.pressingOnGui = false;
			}
		}
	}

	public void render(Graphics g) {
		if (show) {
			g.drawImage(texture, x, y, width, height, null);
			for (int i = 0; i < panels.size(); i++) {
				panels.get(i).render(g, x, y);
			}
			for (int i = 0; i < buttons.size(); i++) {
				if (FFunc.mouseCheckPos(buttons.get(i).getX() + x, buttons.get(i).getY() + y, buttons.get(i).getXA(), buttons.get(i).getYA())) {
					g.setColor(buttons.get(i).getCol1());
				} else {
					g.setColor(buttons.get(i).getCol2());
				}
				g.fillRect(buttons.get(i).getX() + x, buttons.get(i).getY() + y, buttons.get(i).getXA(), buttons.get(i).getYA());
			}
		}
	}

	public void setShow(boolean show) {
		this.show = show;
	}

}
