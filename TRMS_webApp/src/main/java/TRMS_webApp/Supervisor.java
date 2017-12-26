package TRMS_webApp;

public class Supervisor extends Employee {

	Supervisor (String eid, String first, String last, String email, String supervisorID) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.supervisorID = supervisorID;
	}
	
	public Supervisor () {
		// empty constructor!
	}
}
