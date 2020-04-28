package databaseConnections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {
	Connection connection;

	public DBService() {
		this.connection = DatabaseConnectionClass.getDBConnection();
	}

	public Employee getCustomeFromDB(int empid) {
		PreparedStatement smt;
		Employee emp = new Employee();

		try {

			smt = connection.prepareStatement("select * from employeed WHERE empid = ?");
			smt.setInt(1, empid);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {

				emp.setEmpid(rs.getInt("empid"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emp.setEmailid(rs.getString("emailid"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setDateofjoining(rs.getDate("dateofjoining"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;

	}

	public Employee[] getAllCustomerDB() {
		Employee[] emp = new Employee[10];
		Statement smt;
		try {
			smt = connection.createStatement();
			ResultSet rs = smt.executeQuery("select * from employeed");
			int i = 0;
			while (rs.next()) {
				Employee empLocal = new Employee();
				empLocal.setEmpid(rs.getInt("empid"));
				empLocal.setFirstname(rs.getString("firstname"));
				empLocal.setLastname(rs.getString("lastname"));
				empLocal.setEmailid(rs.getString("emailid"));
				empLocal.setSalary(rs.getFloat("salary"));
				empLocal.setDateofjoining(rs.getDate("dateofjoining"));

				emp[i] = empLocal;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	public EmpAddress[] getEmpAddress() {
		Statement smt;
		EmpAddress[] empaddr = new EmpAddress[3];
		try {
			smt = connection.createStatement();
			ResultSet rs = smt.executeQuery("select * from address");
			int i = 0;
			while (rs.next()) {

				EmpAddress addrLocal = new EmpAddress();
				addrLocal.setAddressId(rs.getInt("AddressId"));
				addrLocal.setStreetName(rs.getString("StreetName"));
				addrLocal.setCity(rs.getString("City"));
				addrLocal.setState(rs.getString("State"));
				addrLocal.setZipCode(rs.getInt("Zip"));
				addrLocal.setCountry(rs.getString("Country"));
				empaddr[i] = addrLocal;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empaddr;
	}

	public void updateEmployee(String emailId, int empId) {
		PreparedStatement smt;

		try {
			String sql = "UPDATE employeed SET emailId = ? WHERE empId = ?";
			smt = connection.prepareStatement(sql);
			smt.setString(1, emailId);
			smt.setInt(2, empId);
			int count = smt.executeUpdate();
			if(count>=1) {
				System.out.println("Updated Sucessfully.....");
			}else {
				System.out.println("Oops.......! Something went wrong....");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void insertEmployee(Employee employee) {
		PreparedStatement smt;

		try {
			String sql = "INSERT INTO EMPLOYEEd(firstname,lastname,emailid,salary,dateofjoining) VALUES (?,?,?,?,?)";
			smt = connection.prepareStatement(sql);
			smt.setString(1, employee.getFirstname());
			smt.setString(2, employee.getLastname());
			smt.setString(3, employee.getEmailid());
			smt.setDouble(4, employee.getSalary());
			smt.setDate(5,  employee.getDateofjoining());
			
			int count = smt.executeUpdate();
			if(count>=1) {
				System.out.println("INSERTED Sucessfully.....");
			}else {
				System.out.println("Oops.......! Something went wrong....");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee( int empId) {
		PreparedStatement smt;

		try {
			String sql = "DELETE from employeed WHERE empId = ?";
			smt = connection.prepareStatement(sql);
			smt.setInt(1, empId);
			int count = smt.executeUpdate();
			if(count>=1) {
				System.out.println("Record Deleted Sucessfully.....");
			}else {
				System.out.println("Oops.......! Something went wrong....");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
