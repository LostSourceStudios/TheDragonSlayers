package Main.quest.tutorial;

import Main.Game;
import Main.quest.Quest;
import Main.quest.QuestHandeler;

public class tutorial2 extends Quest {

	public tutorial2(String name, String desc, String desc2, String desc3, int xpReward, String reward, String imagePath) {
		super(name, desc, desc2, desc3, xpReward, reward, imagePath);
	}

	public void isSelected() {

	}

	public void isComplete() {

		if (Game.player.talkingTo != null)
			if (Game.player.talkingTo.type == "guide") {
				onComplete();
				QuestHandeler.addCurrentQuest(tq3);
			}

	}

}
