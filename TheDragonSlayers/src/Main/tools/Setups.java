package Main.tools;

import Main.GUI.GUIHandeler;

public class Setups {

	public static void setupGUIs() {
		GUIHandeler.addGui("Quest", "/textures/GUI/quest.png", 1055, 150, 200, 400);
//		GUIHandeler.addGui("Chat", "/textures/GUI/chat.png", 0, 529, 700, 143);
		GUIHandeler.addGui("Bars", "/textures/GUI/bars.png", 1033, 578, 242, 94);
		GUIHandeler.addGui("Target", "/textures/GUI/target.png", 10, 10, 160 * 2, 80 * 2);

		GUIHandeler.addPanel("Quest", "/textures/GUI/quest.png", "currentQuests", 10, 50, 180, 340);
		GUIHandeler.addPanel("Target", "targetPanel", 10, 10, 160 * 2, 80 * 2);

		int a = 47;
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q1", 5, 5, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q2", 5, 5 + a, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q3", 5, 5 + a + a, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q4", 5, 5 + a + a + a, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q5", 5, 5 + a + a + a + a, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q6", 5, 5 + a + a + a + a + a, 170, a);
		GUIHandeler.addPanelButton("/textures/GUI/questBox.png", "Quest", "currentQuests", "q7", 5, 5 + a + a + a + a + a + a, 170, a);

		GUIHandeler.addPanelButton("/textures/GUI/button2.png", "/textures/GUI/button1.png", "Target", "targetPanel", "talk", 268,28,22,12);

		
		
//		GUIHandeler.setCanMove("Chat", false);
		GUIHandeler.setCanMove("Target", false);
		GUIHandeler.setCanMove("Bars", false);
		GUIHandeler.setShow("Quest", false);
	}
	

	
}
