package databaseConnections;

import java.sql.*;

public class DemoMySQLConnection {
	public static void main(String[] args) {

		Connection connection =	DatabaseConnectionClass.getDBConnection();
		Statement smt;
		try {
			smt = connection.createStatement();
			ResultSet rs = smt.executeQuery("select * from employeed");
			while (rs.next())
				System.out.println(rs.getInt("empid") + "  " + rs.getString("firstname") + "  " + rs.getString("lastname")
						+ "  " + rs.getString("emailid") + "  " + rs.getDouble("salary") + "  "
						+ rs.getDate("dateofjoining"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
