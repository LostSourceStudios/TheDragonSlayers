package Main.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Main.quest.Quest;

public class GUIHandeler {

	public static ArrayList<GUI> guis = new ArrayList<GUI>();
	static Graphics graph;

	public static void addGui(String name, String path, int x, int y, int xa, int ya) {
		GUI g = new GUI(name, path, x, y, xa, ya);
		guis.add(g);
	}

	public static void addButton(String guiName, String name, int x, int y, int xa, int ya) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equals(guiName)) {
				guis.get(i).addButton(name, x, y, xa, ya);
			}
		}
	}
	
	public static void setButtonQuest(String panelName, int buttonNr, Quest q) {
		getPanelByName(panelName).buttons.get(buttonNr).quest = q;
	}

	public static void addPanelButton(String path, String guiName, String panelName, String name, int x, int y, int xa, int ya) {
		getByName(guiName).addQuestButtonToPanel(path, panelName, name, x, y, xa, ya);
	}
	
	public static void addPanelButton(String path, String path2, String guiName, String panelName, String name, int x, int y, int xa, int ya) {
		getByName(guiName).addQuestButtonToPanel(path, path2, panelName, name, x, y, xa, ya);
	}

	public static void addPanel(String guiName, String path, String name, int x, int y, int xa, int ya) {
		getByName(guiName).addPanel(path, name, x, y, xa, ya);
	}
	
	public static void addPanel(String guiName, String name, int x, int y, int xa, int ya) {
		getByName(guiName).addPanel(name, x, y, xa, ya);
	}

	public static void setCanMove(String name, boolean canMove) {
		getByName(name).setCanMove(canMove);
	}

	public static void setShow(String name, boolean show) {
		getByName(name).setShow(show);
	}

	public static boolean getShow(String name) {
		return getByName(name).show;
	}
	
	public static boolean checkButton(String guiName, String panelName, String buttonName) {			
		return getByName(guiName).getPanel(panelName).getButtonByName(buttonName).isPressed;		
	}

	public static void removeGui(String name) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equalsIgnoreCase(name)) {
				guis.remove(i);
			}
		}
	}

	public static void update(String name, boolean b) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equalsIgnoreCase(name)) {
				guis.get(i).setCanMove(b);
			}
		}
	}

	public static panel getPanelByName(String name) {
		for (int i = 0; i < guis.size(); i++) {
			for (int j = 0; j < guis.get(i).panels.size(); j++) {
				if (guis.get(i).panels.get(j).name.equals(name))
					return guis.get(i).panels.get(j);
			}
		}
		return null;
	}

	public static GUI getByName(String name) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equals(name)) {
				return guis.get(i);
			}
		}
		return null;
	}

	public static void setPos(String guiName, int x, int y) {
		getByName(guiName).x = x;
		getByName(guiName).y = y;
	}

	public static void update() {
		for (int i = 0; i < guis.size(); i++) {
			guis.get(i).update();
		}
		GUI.a = false;
	}

	public static void fillRect(String guiName, int x, int y, int xa, int ya, Color c) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equals(guiName)) {
				graph.setColor(c);
				graph.fillRect(x + guis.get(i).x, y + guis.get(i).y, xa, ya);
			}
		}
	}
	
	public static void drawImage(String guiName, Image texture, int x, int y, int xa, int ya) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equals(guiName)) {
				graph.drawImage(texture, x + guis.get(i).x, y + guis.get(i).y, xa, ya, null);
			}
		}		
	}

	public static void drawString(String guiName, String string, int x, int y, Color c) {
		for (int i = 0; i < guis.size(); i++) {
			if (guis.get(i).name.equals(guiName)) {
				graph.setFont(new Font("Verdana", 1, 10));
				graph.setColor(c);
				graph.drawString(string, x + guis.get(i).x, y + guis.get(i).y);

			}
		}
	}
	


	public static void render(Graphics g) {
		graph = g;
		for (int i = 0; i < guis.size(); i++) {
			guis.get(i).render(g);
		}
	}



	

}
