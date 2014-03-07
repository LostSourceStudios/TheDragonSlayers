package Menu.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.Button;
import Flash.Images.FImage;
import Main.Start;
import Main.Start.State;
import Net.MySQL.connect;

public class Selection {

	public Image back;
	private Button button;

	public Selection() {
		back = FImage.loadImage("/textures/Backgrounds/characterselection.png");
		button = new Button();
		button.addButton(35, 618, 135, 52, Color.LIGHT_GRAY, Color.gray, "Exit", false);
		button.setTexture("/textures/GUI/Buttons/quitbutton.png", "/textures/Backgrounds/transparent.png", "Exit");
		button.addButton(570, 560, 137, 52, Color.LIGHT_GRAY, Color.gray, "Play", false);
		button.setTexture("/textures/GUI/Buttons/playbutton.png", "/textures/Backgrounds/transparent.png", "Play");
		button.addButton(1110, 618, 135, 52, Color.LIGHT_GRAY, Color.gray, "Settings", false);
		button.setTexture("/textures/GUI/Buttons/settings.png", "/textures/Backgrounds/transparent.png", "Settings");
		button.addButton(50, 50, 50, 50, Color.LIGHT_GRAY, Color.gray, "Delete", false);
		button.addButton(110, 50, 50, 50, Color.LIGHT_GRAY, Color.gray, "new", false);

		new CharSelect();

	}

	public void update() {

		CharSelect.update();

		if (button.mouseCheckLeft("Delete")) {
			if (!CharSelect.characters.get(CharSelect.selected).name.equals("Empty")) {
				connect.deleteChar(Integer.parseInt(Start.PLAYER_CHARACTER_ID));
				CharSelect.replaceSelectedCharacters(CharSelect.getChar("Empty", "", 0, 0));

			}
		}
		if (CharSelect.characters.get(CharSelect.selected).name.equals("Empty"))
			if (button.mouseCheckLeft("new")) {
				Start.state = State.NEW_CHAR;
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		if (button.mouseCheckLeft("Exit")) {

		}
		if (button.mouseCheckLeft("Play")) {
			Start.state = State.GAME;
		}
	}

	public void render(Graphics g) {
		g.drawImage(back, 0, 0, 1280, 700, null);
		CharSelect.render(g);
		button.render(g);

		g.setFont(new Font("Arial", 1, 25));
		g.setColor(Color.WHITE);

		g.drawString("You are logged in as: ", 50, 50);
		g.drawString(Start.PLAYER_NAME, 50, 80);

	}
}
