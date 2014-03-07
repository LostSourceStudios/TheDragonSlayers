


package Net.MySQL;


import Main.Game;
import Main.Start;

public class updateData {

	public static int updateStats() {
		int xp = (int) Game.player.xp;
		int lvl = Game.player.lvl;
		int hp = (int) Game.player.health;
		int gold = Game.player.gold;
		// UPDATE [table] SET [variable] = [value] WHERE [searchTag] =
		// [searchString]
		System.out.println("UPDATE stats SET " + "hp" + " = " + hp + " WHERE charid=" + Start.PLAYER_CHARACTER_ID);
		try {
			connect.putCommand("UPDATE stats SET " + "xp" + " = " + xp + " WHERE charid=" + Start.PLAYER_CHARACTER_ID, "characters");
			connect.putCommand("UPDATE stats SET " + "hp" + " = " + hp + " WHERE charid=" + Start.PLAYER_CHARACTER_ID, "characters");
			connect.putCommand("UPDATE stats SET " + "level" + " = " + lvl + " WHERE charid=" + Start.PLAYER_CHARACTER_ID, "characters");
			connect.putCommand("UPDATE stats SET " + "gold" + " = " + gold + " WHERE charid=" + Start.PLAYER_CHARACTER_ID, "characters");
		} catch (Exception e) {
			return 0;
		}
		return 1;

	}

}
