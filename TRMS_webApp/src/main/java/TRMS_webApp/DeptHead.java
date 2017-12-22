package TRMS_webApp;

public class DeptHead extends Employee {

	DeptHead (String eid, String first, String last, String reportsTo) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.reportsTo = reportsTo;
	}
	
	DeptHead() {
		// empty constructor
	}
}
