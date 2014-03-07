package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Flash.Button.FFunc;
import Flash.Button.Mouse;
import Flash.Images.FImage;
import FrameWork.Screen;
import Main.GUI.GUIHandeler;
import Main.GUI.Mouse.option.FastOption;
import Main.GUI.Mouse.option.optSpawnMob;
import Main.GUI.Mouse.option.optTarget;
import Main.GUI.Mouse.option.options;
import Main.GUI.Notification.notificationHandeler;
import Main.GUI.Target.targetThing;
import Main.Mob.Mob;
import Main.Mob.Player;
import Main.Mob.NPCs.guide;
import Main.Mob.Spawner.Spawner;
import Main.World.Level;
import Main.World.LevelHandeler;
import Main.World.Teleporter;
import Main.projectile.projectile;
import Main.quest.Quest;
import Main.quest.QuestHandeler;
import Main.tools.Setups;
import Main.tools.Textures;
import Net.Client.Clients;

import com.lss.flasher.LEngine;
import com.lss.flasher.GameObjects.ParticleSpawner;
import com.lss.flasher.GameObjects.ParticleSpawner.type;
import com.lss.flasher.Input.Keyboard;

public class Game {

	// TODO-MessageBox
	// TODO-Particles
	// TODO-Saving quests
	// TODO-Add more quests
	// TODO-Multiplayer

	Image pointer1;
	public static Image toolTip;

	public static Screen screen;
	public static Keyboard key;

	public static Level level;

	public static Mob player;

	public FastOption o;

	public static boolean pressingOnGui = false; // If youre pressing on a gui
													// with the mouse.

	public static int fps; // Frames Per Second.

	public String camMode = "follow"; // The mode for the camera.
	public static boolean Running = false;
	public static boolean walkWithMouse = false; // If the player is controlled
													// by mouse or keyboard.
	public static boolean debug = false;
	
	public boolean world = false;

	public boolean clearMobsWithC = false; // If the player should be able to
											// clear all mobs by pressing c.

	public static int reqX; // The x as the mouse requests when you right click.
	public static int reqY; // The y as the mouse requests when you right click.
	public static Image waypoint; // The Image that appear when the player is
									// walking to a location.

	public static int x; // X Offset for the screen and mobs.
	public static int y; // Y Offset for the screen and mobs.

	@SuppressWarnings("static-access")
	public Game(Keyboard key) {

		
		
		Setups.setupGUIs(); // Setting up all guis.

		screen = new Screen(1280, 720, 64); // Init the screen so we can render
											// stuff.

		
		LevelHandeler.addLevel(new Level("MainWorld", "/mainWorld.png", 5, 5));
		LevelHandeler.addLevel(new Level("WaterWorld", "/waterWorld.png" , 5, 5));
		LevelHandeler.addLevel(new Level("SpawnHouse", "/spawnHouse.png", 2, 6));

		
		Teleporter.addTeleporter(15, 3, 2, 1, 2, 0);
		Teleporter.addTeleporter(2, 1, 15, 3, 0, 2);
		Teleporter.addTeleporter(2, 0, 15, 3, 0, 2);

		
		/*
		 * Load all random sprites here:
		 */
		toolTip = FImage.loadImage("/textures/GUI/toolTip.png");

		// Init the player.
		player = new Player(12 * 64, 14 * 64, key, LevelHandeler.getLevel(0));
		LevelHandeler.addMob(player, 0);


		
		// Loading the player.
		

		// Init the guide.
		Mob m = new guide(4 * 64, 5 * 64, LevelHandeler.getLevel(2), 1);
		LevelHandeler.addMob(m, 2);

		QuestHandeler.addCurrentQuest(Quest.tq1);

		
		/*
		 * Creates the fast options menu, first an array with all options and
		 * then add them to the menu.
		 */
		options[] oo = new options[4];

		oo[3] = new optSpawnMob(FImage.loadImage("/textures/s.png"));
		oo[1] = new optTarget(FImage.loadImage("/textures/pointer1.png"));

		o = new FastOption(oo, key);

		new targetThing();
		// Init the key.
		this.key = key;

		// Spawner.addSpawner(15 * 64, 15 * 64, 5, 120, 0, "dragonBaby");

	}

	int mox, moy;
	boolean t2;
	boolean t1;
	boolean t3;
	public void update() {

		level = LevelHandeler.getSelectedLevel();

		Clients.update();

		notificationHandeler.update();

		Spawner.updateAll();
		QuestHandeler.update();

		Start.client
				.sendData(("10-" + Start.login_name + "-" + player.x + "-" + player.y)
						.getBytes());

		if ((key.key.get(11)) && !t2) {
			GUIHandeler.setShow("Quest", !GUIHandeler.getShow("Quest"));
			QuestHandeler.updateCurrentQuestsToGUI();
			t2 = true;
		} else if (!(key.key.get(11)))
			t2 = false;

		if ((key.key.get(12)) && !t1) {
			debug = !debug;


			
			t1 = true;
		} else if (!(key.key.get(12)))
			t1 = false;

		
		GUIHandeler.update();

		ParticleSpawner.update();

		if (player.dead)
			Start.state = Start.State.DEAD;
		key.update();
		targetThing.update();

		if (key.key.get(10)) {
			Running = true;
			ParticleSpawner.spawnParticle(player.x - x + 32, player.y -y + 50, 2, 50,
					4, 2, type.EXPLOSION, Textures.fireParticle);

		} else
			Running = false;

		if (clearMobsWithC)
			if (key.key.get(9))
				LevelHandeler.getLevel(0).mobs.clear();

		if (camMode.equalsIgnoreCase("followHalf")) {
			if (player.x < x)
				x -= player.speed;
			if (player.y < y)
				y -= player.speed;
			if (player.x + 64 > x + 1280)
				x += player.speed;
			if (player.y + 64 > y + 475)
				y += player.speed;
		}

		if (camMode.equalsIgnoreCase("follow")) {
			int xx = player.x - Start.width / 2;

			// if (player.xa > 0)
			x = xx;

			y = player.y + 64 - Start.height / 2;
		}

		if (camMode.equalsIgnoreCase("mouse"))
			if (FFunc.mouseCheckRight(0, 0, 1280, 480)) {
				if (Mouse.mouseX < mox)
					x -= (Math.abs(mox - Mouse.mouseX) / 10);
				if (Mouse.mouseX > mox)
					x += (Math.abs(mox - Mouse.mouseX) / 10);
				if (Mouse.mouseY < moy)
					y -= (Math.abs(moy - Mouse.mouseY) / 10);
				if (Mouse.mouseY > moy)
					y += (Math.abs(moy - Mouse.mouseY) / 10);

			}

		LevelHandeler.update();
		Teleporter.update();

		if (projectile.targeted != null)
			if (projectile.firedBy.getRange(projectile.targeted) > 500)
				projectile.targeted = null;

		o.update();

	}

	double barLenght;

	public void render(Graphics g) {

		notificationHandeler.render(g);

		screen.setOffset(-x, -y, g);
		LevelHandeler.render(g, -x, -y);
		ParticleSpawner.render(g);
		LevelHandeler.renderMobs(g);

		Clients.render(screen, g);


		LevelHandeler.renderForeground(g, -x, -y);

		Teleporter.render(g);
		
		
		if (camMode.equalsIgnoreCase("mouse"))
			if (FFunc.mouseCheckRight(0, 0, 1280, 480)) {
				g.setColor(Color.blue);
				g.fillOval(mox - 15, moy - 15, 30, 30);
				g.drawLine(mox, moy, Mouse.mouseX, Mouse.mouseY);
				g.fillOval(Mouse.getX() - 5, Mouse.getY() - 5, 10, 10);
			} else {
				mox = Mouse.mouseX;
				moy = Mouse.mouseY;
			}

		o.render(g);

		GUIHandeler.render(g);

		
		targetThing.render(g);

		if (debug) {

			int x = 10;
			int y = 30;
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("Verdana", 1, 10));
			g.drawString("Cam mode: " + camMode, 0 + x, 10 + y);
			g.drawString("Mobs: "
					+ (LevelHandeler.getSelectedLevel().mobs.size() + 1), 0 + x,
					20 + y);
			g.drawString("FPS: " + LEngine.getFPS(), 0 + x, 30 + y);
			g.drawString("Mobs rendered: " + Level.renderedMobs, 0 + x, 40 + y);
			g.drawString("Entitys Rendered: " + Level.renderedEntitys, 0 + x,

			50 + y);
			g.drawString("Particles Rendered: " + ParticleSpawner.renderedParticles, 0 + x,
					60 + y);

			g.drawString("Running: " + Running, 0 + x, 70 + y);
			g.drawString("Targeted: " + targetThing.targeted, 0 + x, 80 + y);
		}
		// if (player.health > 0)
		barLenght = 214.0 / player.maxHealth;
		GUIHandeler.fillRect("Bars", 14, 15,
				(int) (player.health * (barLenght)), 15, Color.red);

		barLenght = 214.0 / player.maxXP;
		GUIHandeler.fillRect("Bars", 14, 39, (int) (player.xp * (barLenght)),
				15, Color.green);
		GUIHandeler.drawString("Bars", (int) (player.xp) + "/" + player.maxXP,
				14, 50, Color.black);
		GUIHandeler.drawString("Bars", "LVL: " + player.lvl, 150, 50,
				Color.black);

		GUIHandeler.drawString("Bars", (int) (player.health) + "/"
				+ (int) player.maxHealth, 14, 26, Color.black);


		
	}

}
