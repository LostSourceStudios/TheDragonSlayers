package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Key implements KeyListener {

	public static boolean canType = false;

	private boolean[] keys = new boolean[25565];
	public ArrayList<Boolean> key = new ArrayList<Boolean>();
	public ArrayList<Integer> keyEvent = new ArrayList<Integer>();

	public boolean getKey(int keyId) {
		return key.get(keyId);
	}

	public void addKey(int event) {
		key.add(false);
		keyEvent.add(event);
	}

	public Key() {

	}

	public void update() {

		for (int i = 0; i < key.size(); i++) {

			key.set(i, keys[keyEvent.get(i)]);

		}

	}

	/** Handle the key typed event from the text field. */
	public void keyTyped(KeyEvent e) {

	}

	public static String a = "";

	/** Handle the key-pressed event from the text field. */
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
		if (canType)
			if (e.getKeyCode() == 8) {
				if (a.length() > 0)
					a = a.substring(0, a.length() - 1);

			} else {
				if (e.getKeyCode() != 16) {
					if (e.getKeyCode() != 17)
						if (e.getKeyCode() != 18)
							if (a.length() < 12)
								a += e.getKeyChar();
				}
			}

	}

	/** Handle the key-released event from the text field. */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void display(KeyEvent e, String keyStatus) {

		// You should only rely on the key char if the event
		// is a key typed event.
		int id = e.getID();
		String keyString;
		if (id == KeyEvent.KEY_TYPED) {
			char c = e.getKeyChar();
			keyString = "key character = '" + c + "'";
		} else {
			int keyCode = e.getKeyCode();
			keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
		}// end of if
		System.out.println(keyString);
	}// end of display

}
