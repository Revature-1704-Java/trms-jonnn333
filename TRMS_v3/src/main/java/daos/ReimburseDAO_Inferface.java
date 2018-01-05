package daos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import the_beans.Employee;
import the_beans.Reimburse;

public interface ReimburseDAO_Inferface {

	// "implemented", not yet tested
	public List<Reimburse> getAllReimbursements();
	public Reimburse getReimbursement(String employeeID);
	
	// match gradeID to find grade in gradingFormat table
	public String findGradeFormatByID (int gradeID);
	
	
	/* possible methods */
	
	// File table
	// reference table is ONLY an index; files stored here
	public ArrayList<File> findRelevantFiles (int reimburseID);
	
	// client command is not pre-determined, but could we split approval/denial/requestInfo up into smaller methods	
	public boolean ApproveReimbursement(int employeeID, int reimburseID, String reason, int status);
	public boolean DenyReinbursement(int reimburseID, String deniedReason, int status);
	public boolean ReqestAddlDoc(int reimburseID, String reason, int status);
	
	// calculate reimbursement amount
	// to be used with the above boolean-return-type methods
	public double calculateReimbursement (Reimburse reimburseEntry); // UNFINISHED
	
	// 7-day auto-timer (do so at some "startup" point?)
	public void autoApprove(int reimburseID, String autoReason, int status);
	
	// insert reimbursement entry
	public void insertReimbursement(Reimburse reimburseEntry);

/*
	Possible query needed for special privileges
	
		Employees (sup, dept, employeeid)
		Reimbursements (reimburse data, employeeid)
		
		// supervisor wants all reimbursements of their employees
		Select * 
		From Reimbursements r
		Where r.EmployeeID = (Select e.EmployeeID from Employee e
							 Where r.EmployeeID = e.EmployeeID AND e.supervisorID = ?)
	 
*/
	
}
