package the_beans;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -1387957067388822119L;
	
	private Integer employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Integer supervisorID;
	private Integer deptHeadID;
	private Integer employeeType_ID; // regular, supervisor, dept. head, or benco

	
	public Employee(Integer eid, String first, String last, String email, String password, 
			Integer supervisorID, Integer deptHeadID, Integer employeeType_ID) {
		
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.password = password;
		
		if (supervisorID == 0) { this.supervisorID = null; }
		else { this.supervisorID = supervisorID; }
		
		if (deptHeadID == 0) { this.deptHeadID = null; }
		else { this.deptHeadID = deptHeadID; }
		
		if (employeeType_ID == 0) { this.employeeType_ID = null; }
		else { this.employeeType_ID = employeeType_ID; }

		System.out.println("object created!");
	}
	
	public Employee() {
		// empty constructor! 
	}
	
	// getters and setters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
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

	public Integer getEmployeeType_ID() {
		return employeeType_ID;
	}

	public void setEmployeeType_ID(Integer employeeType_ID) {
		this.employeeType_ID = employeeType_ID;
	}

	public Integer getSupervisorID() {
		return supervisorID;
	}

	public void setSupervisorID(Integer supervisorID) {
		this.supervisorID = supervisorID;
	}

	public Integer getDeptHeadID() {
		return deptHeadID;
	}

	public void setDeptHeadID(Integer deptHeadID) {
		this.deptHeadID = deptHeadID;
	}

	// implicit if you System.out.println(Object)
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", supervisorID=" + supervisorID + ", deptHeadID=" + deptHeadID
				+ ", employeeType_ID=" + employeeType_ID + "]";
	}

}
