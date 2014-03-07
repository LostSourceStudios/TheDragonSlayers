package Menu.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.Button;
import Flash.Button.FFunc;
import Flash.Images.FImage;
import Main.Start;
import Main.Start.State;
import Net.MySQL.connect;

import com.lss.flasher.Input.Keyboard;

public class NewChar {

	public Image back = FImage.loadImage("/textures/Backgrounds/characterCreation.png");
	public Image marker = FImage.loadImage("/textures/GUI/Buttons/marker.png");
	public Button b;

	public static int selectedClass = 0;

	public NewChar() {

		b = new Button();
		b.addButton(930, 210, 41, 35, Color.LIGHT_GRAY, Color.gray, "genderLeft", false);
		b.setTexture("/textures/GUI/Buttons/arrow-left.png", "/textures/Backgrounds/transparent.png", "genderLeft");

		b.addButton(1177, 210, 41, 35, Color.LIGHT_GRAY, Color.gray, "genderRight", false);
		b.setTexture("/textures/GUI/Buttons/arrow-right.png", "/textures/Backgrounds/transparent.png", "genderRight");

		b.addButton(930, 310, 41, 35, Color.LIGHT_GRAY, Color.gray, "modelLeft", false);
		b.setTexture("/textures/GUI/Buttons/arrow-left.png", "/textures/Backgrounds/transparent.png", "modelLeft");

		b.addButton(1177, 310, 41, 35, Color.LIGHT_GRAY, Color.gray, "modelRight", false);
		b.setTexture("/textures/GUI/Buttons/arrow-right.png", "/textures/Backgrounds/transparent.png", "modelRight");

		b.addButton(44, 617, 135, 52, Color.LIGHT_GRAY, Color.gray, "Back", false);
		b.setTexture("/textures/GUI/Buttons/backbutton.png", "/textures/Backgrounds/transparent.png", "Back");

		b.addButton(1109, 618, 135, 52, Color.LIGHT_GRAY, Color.gray, "Create", false);
		b.setTexture("/textures/GUI/Buttons/createbutton.png", "/textures/Backgrounds/transparent.png", "Create");

	}

	public static String gender = "Male";
	public static String name = "";
	public static String cs = null;

	boolean a = false;

	public void update() {
		Keyboard.canType = true;

		if (FFunc.mouseCheckLeft(60, 163, 287, 89)) {
			selectedClass = 0;

		}
		if (FFunc.mouseCheckLeft(60, 163 + 80, 287, 89)) {
			selectedClass = 1;

		}
		if (FFunc.mouseCheckLeft(60, 163 + 160, 287, 89)) {
			selectedClass = 2;

		}
		if (FFunc.mouseCheckLeft(60, 163 + 160 + 80, 287, 89)) {
			selectedClass = 3;
			
		}
		if (b.mouseCheckLeft("Back")) {
			Start.state = State.SELECT;
			Keyboard.canType = false;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Keyboard.a = "";

		}
		if (b.mouseCheckLeft("Create")) {

			if (connect.getLoadingData("name", "name", Keyboard.a, "characters", "characters").equals(Keyboard.a)) {

				System.err.println("[WARN] Character name already used!!");
				
			} else {
				String c = "";
				if (selectedClass == 0)
					c = "Mage";
				if (selectedClass == 1)
					c = "Priest";
				if (selectedClass == 2)
					c = "Rogue";
				if (selectedClass == 3)
					c = "Warrior";
				connect.putCommand("INSERT INTO characters (account, name, class, gender) VALUES ('" + Start.PLAYER_ID + "', '" + Keyboard.a + "', '" + c + "', '" + gender + "')", "characters");

				System.out.println(CharSelect.selected);
				String newCharId = connect.getLoadingData("guid", "name", Keyboard.a, "characters", "characters");
				connect.putCommand("UPDATE accounts SET char" + CharSelect.selected + "=" + newCharId + " WHERE id=" + Start.PLAYER_ID, "auth");
				connect.putCommand("INSERT INTO stats (charid) VALUES ('" + newCharId + "')", "characters");


				

				CharSelect.replaceSelectedCharacters(CharSelect.getChar(Keyboard.a, c, 0, 0));


			}
			
			Keyboard.a = "";

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Start.state = State.SELECT;

		}

		if (b.mouseCheckLeft("genderLeft") || b.mouseCheckLeft("genderRight")) {
			if (a)
				if (gender.equals("Male"))
					gender = "Female";
				else
					gender = "Male";
			a = false;
		} else {
			a = true;
		}
	}

	public void render(Graphics g) {

		g.drawImage(back, 0, 0, 1280, 700, null);
		b.render(g);

		g.setFont(new Font("Arial", 1, 30));
		g.setColor(Color.white);
		if (gender == "Female")
			g.drawString(gender, 1025, 236);
		else
			g.drawString(gender, 1038, 236);

		g.drawImage(marker, 55, 163 + (85 * selectedClass), 287, 89, null);

		g.drawString(Keyboard.a, 640 - (Keyboard.a.length() * 9), 525);

	}

}
