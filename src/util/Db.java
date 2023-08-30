package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Db {
	private static Db db = new Db();

	private Db() {

	}

	public static Db getObject() {
		return db;
	}

	public Connection getConnection() {
		Properties properties = new Properties();
		Connection con = null;
		try {
			FileReader fileReader = new FileReader("src\\util\\db.properties");
			properties.load(fileReader);
			Class.forName(properties.getProperty("driver"));
			con = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("username"),
					properties.getProperty("password"));
		} 
		catch (ClassNotFoundException | SQLException | IOException ex) {
			System.err.println(ex.getMessage());
		}
		return con;
	}

}
