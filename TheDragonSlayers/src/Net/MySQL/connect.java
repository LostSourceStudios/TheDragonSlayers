


package Net.MySQL;


import java.sql.DriverManager;

import Main.Start;
import Menu.Character.CharSelect;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class connect {

	private static Connection	con;
	private static Statement	st;
	private static ResultSet	rs;
	public static String		host	= "jdbc:mysql://99.236.252.115:3306/";
	public static String		SQLuser	= "admin";
	public static String		SQLpass	= "lss";

	// public static String host = "jdbc:mysql://localhost:3306/";
	// public static String SQLuser = "root";
	// public static String SQLpass = "ascent";

	public static void deleteChar(int id) {
		String SQL = "DELETE FROM characters WHERE guid = " + id + " ";
		String SQL1 = "DELETE FROM stats WHERE guid = " + id + " ";
		String delCommand = "UPDATE accounts SET char" + CharSelect.selected + "=0 WHERE id=" + Start.PLAYER_ID;
		putCommand(SQL1, "characters");
		putCommand(SQL, "characters");
		putCommand(delCommand, "auth");

	}

	public static void putCommand(String command, String dataBase) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(host + dataBase, SQLuser, SQLpass);

			st = (Statement) con.createStatement();

			st.executeUpdate(command);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public static String getLoadingData(final String key, final String searchKey, final String searchFor, final String dataBase, final String table) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(host + dataBase, SQLuser, SQLpass);

			st = (Statement) con.createStatement();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		try {

			String query = "select * from " + table;
			rs = (ResultSet) st.executeQuery(query);

			while (rs.next()) {
				String db_username = rs.getString(searchKey);
				if (db_username.equals(searchFor)) {
					return rs.getString(key);
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);

		}

		return "";

	}

	static String	a	= "null";

	public static String getData(final String key, final String searchKey, final String searchFor, final String dataBase, final String table) {
		a = "0";

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					Class.forName("com.mysql.jdbc.Driver");

					con = (Connection) DriverManager.getConnection(host + dataBase, SQLuser, SQLpass);

					st = (Statement) con.createStatement();

				} catch (Exception e) {
					System.out.println("Error: " + e);
				}

				try {

					String query = "select * from " + table;
					rs = (ResultSet) st.executeQuery(query);

					while (rs.next()) {
						String db_username = rs.getString(searchKey);
						if (db_username.equals(searchFor)) {
							a = rs.getString(key);
							System.out.println(rs.getString(key) + ", " + a);
						}
					}

					// if (!HAS_LOGIN_INFO) {
					// System.err.println("[WARN/NET] Could not get data from MySQL!! ");
					// System.err.println("[WARN/NET] Please check your internet connection. If problem persists contact support.");
					// }

				} catch (Exception e) {
					System.out.println("Error: " + e);

				}

			}

		}).start();

		return a;

	}

	public static boolean	HAS_LOGIN_INFO	= false;	// If the game
														// successfully
														// retrieved data from
														// MySQL
														// database.

	public static String getData(String key, String username, String dataBase, String table) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(host + dataBase, SQLuser, SQLpass);

			st = (Statement) con.createStatement();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		try {

			String query = "select * from " + table;
			rs = (ResultSet) st.executeQuery(query);
			while (rs.next()) {
				String db_username = rs.getString("username");

				if (db_username.equals(username)) {
					return rs.getString(key);

				}

			}

			// if (!HAS_LOGIN_INFO) {
			// System.err.println("[WARN/NET] Could not get data from MySQL!! ");
			// System.err.println("[WARN/NET] Please check your internet connection. If problem persists contact support.");
			// }
		} catch (Exception e) {

			System.out.println("Error: " + e);

		}
		return "null";
	}

}
