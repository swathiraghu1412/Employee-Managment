package databaseConnections;

import java.sql.Date;

public class Employee {
	private int empid;
	private String firstname;
	private String lastname;
	private String emailid;
	private double salary;
	private Date dateofjoining;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", salary=" + salary + ", dateofjoining=" + dateofjoining + "]";
	}
	
	
}
