package database;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectDB {
	private static Connection con = null;

	public static String getConnect() {
		String str = null;
		try (var file = new FileInputStream("database.properties");) {
			var p = new Properties();
			p.load(file);
			str = p.getProperty("url");
			str = str + p.getProperty("serverName");
			str = str + ":" + p.getProperty("portNumber");
			str = str + "; databasename=" + p.getProperty("databaseName");
			str = str + "; user=" + p.getProperty("user");
			str = str + "; password=" + p.getProperty("password");
			str = str + "; encrypt=" + p.getProperty("encrypt");
			str = str + "; trustServerCertificate=" + p.getProperty("trustServerCertificate");

		} catch (Exception e) {
			e.printStackTrace();
			str = null;
			// JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return str;
	}

	public static Connection connect() {
		try {
			con = DriverManager.getConnection(getConnect());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
