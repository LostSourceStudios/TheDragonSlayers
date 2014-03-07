package Main.quest.tutorial;

import Main.Game;
import Main.quest.Quest;

public class tutorial3 extends Quest {

	public tutorial3(String name, String desc, int xpReward, String reward,
			String imagePath) {
		super(name, desc, xpReward, reward, imagePath);
	}

	public void isSelected() {

	}

	public void isComplete() {
		if (Game.player.latestKill != null)
			if (Game.player.latestKill.type == "dragonBaby") {
				onComplete();
			}
	}

}
