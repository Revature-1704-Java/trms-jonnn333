package com.Revature.TRMS;

import java.sql.SQLException;

public class App {
	
	
	// note: don't rely on main too heavily! 12/20/17
	// "do not use main in your project" - Mehrab, 12/21/17
	
	/*
	 Tuition Reimbursement Management System (TRMS)
	 	[similar to ExpReimburseSystem]
	 	
	 	Requirements:
	 		- as many business requirements (as possible)
	 		- RDS
	 		- Stored procedures
	 		- DAO, Factories/Singleton
	 		- ERDs (design your own db + table data) (+ some UML for personal use)
	 		- JUnit, Maven, log4j
	 		- Documentation (ie. readme files, java comments, some sort of routine) 
	 	
	 */
	
    public static void commenceStartup() {
    	
    	ReimburseDAO reimburse = new ReimburseDAO();
    	EmployeeDAO employee = new EmployeeDAO();
    	SupervisorDAO superv = new SupervisorDAO();
    	DeptHeadDAO dept = new DeptHeadDAO();
    	BenCoDAO bCoordntr = new BenCoDAO();
    	    	
    	
    }
}
