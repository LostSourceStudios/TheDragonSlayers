package Main.LoadingAndSaving;

import java.io.File;

import Flash.File.file;

public class SinglePlayerLoading {


	
	public static String[] loadQuest(String name, String questName) {
		String[] s = new String[3];
		file f = new file();
		f.loadFile(System.getProperty("user.home") + File.separator + ".TheDragonSlayers" + File.separator + name + File.separator + "quests", questName + ".txt");
		f.readFile();
		f.close();
		s[0] = file.text.get(0);
		s[1] = file.text.get(1);
		s[2] = file.text.get(2);

		file.text.clear();
		return s;
	}

	public static void saveQuest(String[] toSave) {
		file f = new file();
		f.openFile(System.getProperty("user.home") + File.separator + ".TheDragonSlayers" + File.separator + toSave[0] + File.separator + "quests", toSave[0] + ".txt");
		f.save(toSave[0] + " ");
		f.save(toSave[1] + " ");
		f.save(toSave[2] + " ");
		f.closeFile();
	}

	public static String[] loadPlayer(String name) {
		String[] s = new String[8];
		file f = new file();
		f.loadFile(System.getProperty("user.home") + File.separator + ".TheDragonSlayers" + File.separator + name, "playerSave.txt");
		f.readFile();
		f.close();
		s[0] = file.text.get(0);
		s[1] = file.text.get(1);
		s[2] = file.text.get(2);
		s[3] = file.text.get(3);
		s[4] = file.text.get(4);
		s[5] = file.text.get(5);
		s[6] = file.text.get(6);
		s[7] = file.text.get(7);
		file.text.clear();
		return s;
	}

	public static void savePlayer(String[] toSave) {
		file f = new file();
		f.openFile(System.getProperty("user.home") + File.separator + ".TheDragonSlayers" + File.separator + toSave[0], "playerSave.txt");
		f.save(toSave[0] + " ");
		f.save(toSave[1] + " ");
		f.save(toSave[2] + " ");
		f.save(toSave[3] + " ");
		f.save(toSave[4] + " ");
		f.save(toSave[5] + " ");
		f.save(toSave[6] + " ");
		f.save(toSave[7]);
		f.closeFile();
	}

}
