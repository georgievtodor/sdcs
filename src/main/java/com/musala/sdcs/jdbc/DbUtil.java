package com.musala.sdcs.jdbc;

import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;

/**
 * This class makes connection with the DB
 *
 */
public class DbUtil {
	private static Connection dbConnection = null;

	/**
	 * @return DB Connection
	 */
	public static Connection getConnection() {
		if (dbConnection != null) {
			return dbConnection;
		}

		try {
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();

			properties.load(inputStream);
			
			String dbDriver = properties.getProperty("dbDriver");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String connectionUrl = properties.getProperty("connectionUrl");

			Class.forName(dbDriver).newInstance();
			dbConnection = DriverManager.getConnection(connectionUrl, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

}
