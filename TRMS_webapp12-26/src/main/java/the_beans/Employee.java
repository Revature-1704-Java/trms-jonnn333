package the_beans;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -1387957067388822119L;
	
	private String employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String supervisorID;
	private String employeeType; // regular, supervisor, dept. head, or benco
	
	private Employee supervisor;
	
	public Employee(String eid, String first, String last, String email, String password, String supervisorID) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.password = password;
		this.supervisorID = supervisorID;
		//System.out.println("object created!");
	}
	
	Employee() {
		// empty constructor! 
	}
	
	// getters and setters
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getReportsTo() {
		return supervisorID;
	}

	public void setReportsTo(String supervisorID) {
		this.supervisorID = supervisorID;
	}
	
}
