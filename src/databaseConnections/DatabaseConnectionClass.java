package databaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionClass {
	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/testdb?characterEncoding=latin1&useConfigs=maxPerformance", "root",
						"swathi");
			} catch (SQLException e) {
				System.out.println("oops..! something went wrong....!" + e);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);

		}
		return con;
	}
}
