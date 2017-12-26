package TRMS_webApp;

public class DeptHead extends Employee {

	DeptHead (String eid, String first, String last, String email, String supervisorID) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.supervisorID = supervisorID;
	}
	
	DeptHead() {
		// empty constructor
	}
}
