package Main.quest;

import java.awt.Image;

import Flash.Images.FImage;
import Main.Game;
import Main.GUI.Notification.notificationHandeler;
import Main.quest.tutorial.tutorial1;
import Main.quest.tutorial.tutorial2;
import Main.quest.tutorial.tutorial3;

public class Quest {

	public static Quest tq1 = new tutorial1("Tutorial One", "Find the Guide",
			"(He is green).", 5, "Glory", "/textures/quests/I.png");
	public static Quest tq2 = new tutorial2("Tutorial Two",
			"Talk to him by holding", " right click on him and",
			" draw to the right.", 2, "Glory", "/textures/quests/I.png");

	public static Quest tq3 = new tutorial3("Tutorial Three",
			"Go kill a dragon", 20, "Glory", "/textures/quests/I.png");

	public String name;
	public String desc1;
	public String desc2 = "";
	public String desc3 = "";

	public int xpReward;
	public String reward;
	public boolean done = false;
	public String imagePath;
	public Image icon;

	public void isSelected() {

	}

	public void isComplete() {

	}

	public void onComplete() {
		if (!done)
			Game.player.xp += xpReward;
		done = true;
		notificationHandeler.addNote("Quest " + name + " complete! Good job!");

	}

	public void update() {
		isComplete();
	}

	public Quest(String name, String desc, int xpReward, String reward,
			String imagePath) {
		this.name = name;
		this.desc1 = desc;
		this.xpReward = xpReward;
		this.reward = reward;
		this.imagePath = imagePath;
		icon = FImage.loadImage(imagePath);

	}

	public Quest(String name, String desc1, String desc2, int xpReward,
			String reward, String imagePath) {
		this.name = name;
		this.desc1 = desc1;
		this.desc2 = desc2;

		this.xpReward = xpReward;
		this.reward = reward;
		this.imagePath = imagePath;
		icon = FImage.loadImage(imagePath);

	}

	public Quest(String name, String desc1, String desc2, String desc3,
			int xpReward, String reward, String imagePath) {
		this.name = name;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.xpReward = xpReward;
		this.reward = reward;
		this.imagePath = imagePath;
		icon = FImage.loadImage(imagePath);

	}

}
