package TRMS_webApp;

public class BenCo extends Employee {

	String provideReason;
	String requestAddendum;
	
	 BenCo(String eid, String first, String last, String email, String supervisorID) {
		 this.employeeID = eid;
		 this.firstName = first;
		 this.lastName = last;
		 this.email = email;
		 this.supervisorID = supervisorID;
	 }
	 
	 BenCo () {
		 // empty constructor!
	 }
}
