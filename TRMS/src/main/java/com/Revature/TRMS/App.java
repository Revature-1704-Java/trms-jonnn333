package com.Revature.TRMS;

import java.sql.SQLException;

public class App {
	
	
	// note: don't rely on main too heavily! 12/20/17
	// "do not use main in your project" - Mehrab
	
	/*
	 Tuition Reimbursement Management System (TRMS)
	 	[similar to ExpReimburseSystem]
	 */
	
    public static void commenceStartup() {
    	
    	ReimburseDAO reimburse = new ReimburseDAO();
    	EmployeeDAO employee = new EmployeeDAO();
    	SupervisorDAO superv = new SupervisorDAO();
    	DeptHeadDAO dept = new DeptHeadDAO();
    	BenCoDAO bCoordntr = new BenCoDAO();
    	    	
    	
    }
}
