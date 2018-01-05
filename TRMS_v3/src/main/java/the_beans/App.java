package the_beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import daos.EmployeeDAO;
import daos.ReimburseDAO;


public class App {
	
	
	// note: don't rely on main too heavily! 12/20/17
	// "do not use main in your project" - Mehrab, 12/21/17
	
	// DUE: January 5th, 2018 (4 days!) 
	
	/*
	 Tuition Reimbursement Management System (TRMS)
	 	[similar to ExpReimburseSystem]
	 	
	 	Requirements:		[y] = yes	[i-p] = in-progress	[] = not yet started
	 		- [y] as many business requirements (as possible)
	 		- [y] RDS, 11g Database
	 		- [y] Stored procedures (use DAO example for inspiration)
	 		- [y] DAO, Factories/Singleton	
	 		- [y] ERDs (design your own db + table data) (+ some UML for personal use)
	 		- [] JUnit, Maven, log4j [test | build | logging-anything]
	 		- [y] Documentation (ie. readme files, java comments, some sort of routine)
	 		- [i-p] Servlets (+12/28/17)
	 		- [i-p] HTML/CSS/JS (+12/28/17)
	 		- [] AJAX (+12/28/17) [XMLHTTPRequest]
	 	- Additional todo
	 		- [] presentation slides, code, live version of website (replaces usual 1-on-1)
	 		
	 	Notes
	 		- have some triggers and stored procedures called in Java dao files
	 		- have middle tier (Java) do checks (ie. servlets) to remove load from db?
	 		
	 	Problems:
	 		1a) int cannot accept null; returns a 0 if SQL NULL though!
	 		1b) Integer won't be able to take getInt() output; it returns primitive int value
	 		2) NOTE: html pages need to be in SAME DIRECTORY as webapp AND WEB-INF; cannot be in folder
	 	Solutions:
	 		1a, 1b) using getObject() and casting to (Integer);; correction: int can hold between approx. -2M to 2M
	 */
	
	
	// TEST PURPOSES ONLY
    public static void main(String[] args) {
    	
    	ReimburseDAO reimburse = new ReimburseDAO();
    	EmployeeDAO employee = new EmployeeDAO();
    	
    	System.out.println("about to call dao");
    	
    	List<Employee> allEmployList = employee.getAllEmployees();
    	
    	System.out.println("list retrieved. size of it is: "+allEmployList.size());
    	
    	for (Employee guy : allEmployList) {
    		System.out.println(guy.getFirstName() + " " + guy.getLastName() + ", whose id is " + guy.getEmployeeID().intValue());
    	}
    	
    	//JsonNode json; // need mappers and arrayNodes 
    }
}
