package TRMS_webApp;

public class BenCo extends Employee {

	String provideReason;
	String requestAddendum;
	
	 BenCo(String eid, String first, String last, String reportsTo) {
		 this.employeeID = eid;
		 this.firstName = first;
		 this.lastName = last;
		 this.reportsTo = reportsTo;
	 }
	 
	 BenCo () {
		 // empty constructor!
	 }
}
