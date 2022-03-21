package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

		// made static to share with all instances, only one connection can exist
		private static Connection con; 
		
		// return connection if exists/is open
		public static Connection getConnectionFromEnv() throws SQLException{
			String url = System.getenv("DB_URL");
			String username = System.getenv("DB_USER");
			String password = System.getenv("DB_PASS");
			
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(url, username, password);
			}
			return con;
		}
}
