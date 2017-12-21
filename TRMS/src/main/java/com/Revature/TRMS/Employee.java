package com.Revature.TRMS;

public class Employee {

	String employeeID;
	String firstName;
	String lastName;
	String reportsTo;
	
	Employee(String eid, String first, String last, String reportsTo) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.reportsTo = reportsTo;
		Reimburse employSpecs = new Reimburse();
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
}
