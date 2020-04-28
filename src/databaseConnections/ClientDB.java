package databaseConnections;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ClientDB {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DBService customerdetails = new DBService();
		System.out.println("select your operation");
		System.out.println("1  Search with EmpId");
		System.out.println("2  Search for all Employees");
		System.out.println("3 Search for all Employee address ");
		System.out.println("4 Update EmployeeId ");
		System.out.println("5 Create new Employee ");
		System.out.println("6 Delete Employee ");
		int operation = input.nextInt();

		switch (operation) {

		case 1:
			System.out.println("Enter the ID no :  ");
			int empid = input.nextInt();

			Employee getcustomefromDB = customerdetails.getCustomeFromDB(empid);
			System.out.println(getcustomefromDB.toString());
			break;

		case 2:
			Employee empArray[] = customerdetails.getAllCustomerDB();
			for (int i = 0; i < 10; i++) {
				System.out.println(empArray[i].toString());
			}
			break;

		case 3:
			EmpAddress[] getempaddress = customerdetails.getEmpAddress();
			for (EmpAddress address : getempaddress) {
				System.out.println(address.toString());
			}

			break;

		case 4:
			System.out.println("Performing Update Operator");

			System.out.println("Enter the primary Id");
			int empId = input.nextInt();
			System.out.println("Enter the Email Id");
			String emailId = input.next();
			customerdetails.updateEmployee(emailId, empId);
			break;

		case 5:
		
			Employee insertemp = new Employee();
			
			System.out.println("Inserting data ");
			System.out.println("");
	
			System.out.println("Enter the FirstName : ");
			String firstname = input.next();
			insertemp.setFirstname(firstname);

			System.out.println("Enter the lastname : ");
			String lastname = input.next();
			insertemp.setLastname(lastname);

			System.out.println("Enter your EmailId : ");
			String emailid = input.next();
			insertemp.setEmailid(emailid);
			
			System.out.println("Enter your Salary : ");
			double salary = input.nextDouble();
			insertemp.setSalary(salary);

			// System.out.println("Enter the DateOfJoining in \"dd-MMM-yyyy\" Format: ");
			// String date = input.next();
			Date sqldate = new Date(12, 12, 12);
			insertemp.setDateofjoining(sqldate);

			
			customerdetails.insertEmployee(insertemp);

			break;
			
		case 6:
			System.out.println("Deleting the record");
			System.out.println("");
			System.out.println("Enter the empId : ");
			int deleteempId = input.nextInt();
			customerdetails.deleteEmployee(deleteempId);
		default:
			System.out.println("Invalid Operation Selected....");
		}

		input.close();
	}

	private static Date convertStringToDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date2 = null;
		try {
			// Parsing the String
			date2 = (Date) dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
		
		
	}
	
	

}
