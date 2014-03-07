package Menu.Character;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Flash.Images.FImage;
import Main.Start;
import Menu.Loading.Loading;

public class CharSelect {

	public static ArrayList<Character> characters = new ArrayList<Character>();
	public static Image marker = FImage.loadImage("/textures/GUI/Buttons/marker.png");

	public static int selected = 0;
	

	
	public CharSelect() {
	}

	public static void addChar(String name, String game_class, int team, int level) {
		
		if (characters.size() < 4) {
			Character c = new Character(name, game_class, team, 55, 143 + ((85 + 10) * characters.size()), 300, 85, level);
			characters.add(c);
		}

	}
	
	public static Character getChar(String name, String game_class, int team, int level) {
		return new Character(name, game_class, team, 55, 143 + ((85 + 10) * selected), 300, 85, level);
		
	}
	
	
	public static void replaceSelectedCharacters(Character c) {
		characters.set(selected, c);
	}
	
	public static void removeSelectedCharacter() {
		characters.remove(selected);
		addChar("Empty", "", 0,0);
	}
	
	public static void update() {
		
		
		
		if (selected == 0) {
			Start.PLAYER_CHARACTER_ID = Loading.char1id;

		}
		if (selected == 1) {
			Start.PLAYER_CHARACTER_ID = Loading.char2id;

		}
		if (selected == 2) {
			Start.PLAYER_CHARACTER_ID = Loading.char3id;

		}
		if (selected == 3) {
			Start.PLAYER_CHARACTER_ID = Loading.char4id;

		}
		
		for (int i = 0; i < characters.size(); i++) {
			characters.get(i).update();
			
//			characters.get(i).isSelected = characters.get(i).isMouseOver;
			
			if (characters.get(i).isPressed) {
				selected = i;
			}
			
			if (characters.get(i).isMouseOver) {
				
			}
			
		}

	}

	public static void render(Graphics g) {
		for (int i = 0; i < characters.size(); i++) {
			characters.get(i).render(g);
			if (selected == i) characters.get(i).isSelected = true;
			else characters.get(i).isSelected = false;
		}

	}

}
