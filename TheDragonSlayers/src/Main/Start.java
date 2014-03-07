


package Main;


import java.awt.event.KeyEvent;

import Flash.Button.Mouse;
import Menu.Character.CharSelect;
import Menu.Character.NewChar;
import Menu.Character.Selection;
import Menu.Loading.Loading;
import Net.Client.Client;
import Net.MySQL.updateData;

import com.lss.flasher.LEngine;

public class Start extends LEngine {

	/*
	 * This class is made by Pontus Wirsching. Last updated 2013-06-14.
	 */

	public enum State {
		MENU, GAME, DEAD, SELECT, NEW_CHAR, LOADING
	}

	public static int			width				= 1280;
	public static int			height				= 700;
	public final static String	TITLE				= "The Dragon Slayers ALPHA";
	public final static String	VERSION				= "0.1";
	public static boolean		online				= false;
	public static String		login_name			= "Flasher";
	public static String		login_password		= "null";
	public static int			PLAYER_ID			= 0;
	public static String		PLAYER_NAME			= "";
	public static String		PLAYER_EMAIL		= "";
	public static int			GUID				= 0;
	public static String		PLAYER_CHARACTER_ID	= "";
	private final menu			m;
	private final Game			game;
	private final deadMenu		d;
	private final Selection		s;
	private final NewChar		c;
	private final Loading		l;
	public static Client		client;
	public static State			state				= State.LOADING;				// ------------------------------------------------------------------------HERE

	public Start() {
		super(width, height, TITLE + "    |    " + VERSION);

		enable(LE_PARTICLES);
		enable(LE_SPRITES);

		Mouse mouse = new Mouse();
		getFrame().addMouseListener(mouse);
		getFrame().addMouseMotionListener(mouse);

		/*
		 * To add keys you need to do the key.addKey(KeyEvent.VK_"key"). You
		 * must do it in the right order because it is adding them in to an
		 * array list and then you use key.key.get("key value") witch returns a
		 * boolean if the key is pressed.
		 */

		key.addKey(KeyEvent.VK_UP); // Key Value 0
		key.addKey(KeyEvent.VK_DOWN); // 1
		key.addKey(KeyEvent.VK_LEFT); // 2
		key.addKey(KeyEvent.VK_RIGHT); // 3
		key.addKey(KeyEvent.VK_W); // 4
		key.addKey(KeyEvent.VK_S); // 5
		key.addKey(KeyEvent.VK_A); // 6
		key.addKey(KeyEvent.VK_D); // 7
		key.addKey(KeyEvent.VK_CONTROL); // 8
		key.addKey(KeyEvent.VK_C); // 9
		key.addKey(KeyEvent.VK_SHIFT); // 10
		key.addKey(KeyEvent.VK_L); // 11
		key.addKey(KeyEvent.VK_F3); // 12
		key.addKey(KeyEvent.VK_SPACE); // 13

		m = new menu();
		game = new Game(key);
		d = new deadMenu();
		s = new Selection();
		c = new NewChar();
		l = new Loading();

		if (!online) {
			state = State.SELECT;
			PLAYER_ID = 0;
			PLAYER_NAME = "OFFLINE_PLAYER";
			PLAYER_EMAIL = "offline_player@gmail.com";
			PLAYER_CHARACTER_ID = "0";
			CharSelect.addChar("Default", "mage", 0, 0);
			CharSelect.addChar("Empty", "", 0, 0);
			CharSelect.addChar("Empty", "", 0, 0);
			CharSelect.addChar("Empty", "", 0, 0);

		} else {
			l.t.start();
		}

		start();

		client = new Client("213.89.74.79", 1234);
		client.start();

		client.sendData(("00" + login_name).getBytes());

	}

	@Override
	public void onExit() {

		if (state == State.GAME) {
			if (online) {
				state = State.LOADING;
				if (updateData.updateStats() == 1) {
					System.exit(0);
				}
			}else {
				System.out.println("Exit");
				System.exit(0);
			}
			// l.t.start();
		} else {
			System.out.println("Exit");
			System.exit(0);
		}

	}

	public void update() {

		key.update();

		if (state == State.MENU) m.update();
		if (state == State.GAME) game.update();
		if (state == State.DEAD) d.update();
		if (state == State.SELECT) s.update();
		if (state == State.NEW_CHAR) c.update();
		if (state == State.LOADING) l.update();

	}

	public void render() {

		if (state == State.MENU) m.render(g);
		if (state == State.GAME) game.render(g);
		if (state == State.DEAD) d.render(g);
		if (state == State.SELECT) s.render(g);
		if (state == State.NEW_CHAR) c.render(g);
		if (state == State.LOADING) l.render(g);

	}

	public static void main(String[] args) {
		if (online) {
			login_name = args[0];
			login_password = args[1];
		}
		new Start();

	}

}
