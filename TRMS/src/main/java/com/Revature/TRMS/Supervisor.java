package com.Revature.TRMS;

public class Supervisor extends Employee {

	Supervisor (String eid, String first, String last, String reportsTo) {
		this.employeeID = eid;
		this.firstName = first;
		this.lastName = last;
		this.reportsTo = reportsTo;
	}
	
	Supervisor () {
		// empty constructor!
	}
}
