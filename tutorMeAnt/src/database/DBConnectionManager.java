package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Peggy
 */

public class DBConnectionManager {
	
	
	
	
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutormedb", "root", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
        
        

}
