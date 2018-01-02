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
	
	
	/* possible methods */
	
	// gradingFormat table
	public String FindGradeFormatByID (int gradeID);
	
	// File table
	// reference table is ONLY an index; files stored here
	public ArrayList<File> findRelevantFiles (int reimburseID);
	
	/* supervisor, head dept., or benco can modify */
	// adjust to $1000 limit and approve
	public boolean modifyReimburseLim(int reimburseID, String reason);
	
	// just approve, amount okay, amount below $1000-per-employee threshold
	// do valid checks for input
	public boolean approveReimburse(int reimburseID);
	
	// reimburseID (unique)
	// do valid checks for inputs
	public boolean requestAddlDocs(int reimburseID, int status, String reason); 
	
	// reasons for denial, request additional documents, or explain why approval amount exceeds limit
	// do valid checks for inputs
	public boolean setReason(int reimburseID, String reason);
	
	
}
