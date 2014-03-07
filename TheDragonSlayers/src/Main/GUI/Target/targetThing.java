package Main.GUI.Target;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Main.GUI.GUIHandeler;
import Main.Mob.Mob;

public class targetThing {
	
	public static Image texture;
	public static Mob targeted;
	


	
	public void onTalk() {
		
	}

	public static void update() {


		
		if (targeted == null) {
			GUIHandeler.setShow("Target", false);
		} else {
			GUIHandeler.setShow("Target", true);
			targeted.isTalkingTo(GUIHandeler.checkButton("Target", "targetPanel", "talk"));
			
			
			

		}
	}

	public static void render(Graphics g) {
		if (targeted != null) {			
			GUIHandeler.fillRect("Target", 154, 24, (int) (targeted.health * 1.20), 12, Color.red);
			GUIHandeler.drawImage("Target", targeted.icon, 38,38,70,70);
			GUIHandeler.drawString("Target", "Talk:......................", 155,48, Color.white);

		
		}
	}

}
