package Main.quest.tutorial;

import Main.Game;
import Main.World.LevelHandeler;
import Main.quest.Quest;
import Main.quest.QuestHandeler;

public class tutorial1 extends Quest {

	public tutorial1(String name, String desc, String desc2, int xpReward,
			String reward, String imagePath) {
		super(name, desc, desc2, xpReward, reward, imagePath);
	}

	public void isSelected() {

	}

	public void isComplete() {
		if (LevelHandeler.selectedLevel == 2)
			if (Game.player.getRange(LevelHandeler.getSelectedLevel().getMob(
					"guide")) < 100) {
				onComplete();
				QuestHandeler.addCurrentQuest(tq2);
			}
	}

}
