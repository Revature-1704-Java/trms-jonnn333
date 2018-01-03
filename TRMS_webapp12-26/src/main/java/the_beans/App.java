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
	 	
	 	Requirements:
	 		- [] as many business requirements (as possible)
	 		- [] RDS
	 		- [] Stored procedures (use DAO example for inspiration)
	 		- [y] DAO, Factories/Singleton	
	 		- [y] ERDs (design your own db + table data) (+ some UML for personal use)
	 		- [] JUnit, Maven, log4j
	 		- [y] Documentation (ie. readme files, java comments, some sort of routine)
	 		- [] Servlets (+12/28/17)
	 		- [] HTML/CSS/JS (+12/28/17)
	 		- [] AJAX (+12/28/17)
	 	- Additional todo
	 		- [] presentation slides, code, live version of website (replaces usual 1-on-1)
	 		
	 	Notes
	 		- have some triggers and stored procedures called in Java dao files
	 		- have middle tier (Java) do checks (ie. servlets) to remove load from db?
	 */
	
	
	// TEST PURPOSES ONLY
    public static void main(String[] args) {
    	
    	ReimburseDAO reimburse = new ReimburseDAO();
    	EmployeeDAO employee = new EmployeeDAO();
    	
    	List<Employee> allEmployList = employee.getAllEmployees();
    	for (Employee guy : allEmployList) {
    		System.out.println(guy.getFirstName() + " " + guy.getLastName() + ", whose id is " + guy.getEmployeeID());
    	}
    	
    	JsonNode json; // need mappers and arrayNodes 
    }
}
