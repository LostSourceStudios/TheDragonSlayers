package Main.quest;

import java.util.ArrayList;

import Main.GUI.GUIHandeler;

public class QuestHandeler {

	public static ArrayList<Quest> currentQuests = new ArrayList<>();

	public static void updateCurrentQuestsToGUI() {
		for (int i = 0; i < currentQuests.size(); i++) {
			GUIHandeler.setButtonQuest("currentQuests", i, currentQuests.get(i));
		}
	}
	
	public static void clearQuestButtonGUI(int i) {
		GUIHandeler.setButtonQuest("currentQuests", i, null);
	}

	public static void addCurrentQuest(Quest quest) {
		currentQuests.add(quest);
	}

	public static void update() {

		updateCurrentQuestsToGUI();
		for (int i = 0; i < currentQuests.size(); i++) {
			currentQuests.get(i).update();
			if (currentQuests.get(i).done) {
				clearQuestButtonGUI(i);
				currentQuests.remove(i);
			}

		}
	}

	// public static void saveCurrentQuest() {
	// file f = new file();
	// f.openFile(System.getProperty("user.home") + File.separator +
	// ".TheDragonSlayers" + File.separator + Start.name + File.separator +
	// "quests", "current.txt");
	// for (int i = 0; i < currentQuests.size(); i++) {
	// f.save(toString(currentQuests.get(i)));
	// f.newLine();
	// }
	// f.closeFile();
	// }
	//
	// public static String toString(Quest q) {
	// String a = "";
	// a = (q.name + "-" + q.desc + "-" + q.reward + "-" + q.xpReward + "-" +
	// q.done + "-" + q.imagePath);
	// return a;
	// }
	//
	// public static void loadCurrentQuests() {
	// file f = new file();
	// f.loadFile(System.getProperty("user.home") + File.separator +
	// ".TheDragonSlayers" + File.separator + Start.name + File.separator +
	// "quests", "current.txt");
	// f.readFile();
	// f.close();
	// for (int i = 0; i < file.text.size(); i++) {
	// String message = new String(file.text.get(i));
	// String[] array = message.trim().split("-");
	//
	// Quest q = new Quest(array[0], array[1], Integer.parseInt(array[3]),
	// array[2], Boolean.parseBoolean(array[4]), array[5]);
	// currentQuests.add(q);
	//
	// }
	// file.text.clear();
	// }

}
