package the_beans;

import java.io.Serializable;

public class Employee implements Serializable {

	String employeeID;
	String firstName;
	String lastName;
	String email;
	String supervisorID;
	
	public Employee(String eid, String first, String last, String email, String supervisorID) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.supervisorID = supervisorID;
	}
	
	Employee() {
		// empty constructor! 
	}

	// custom methods
	public void requestApproval () {
		System.out.println("request sent");
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
