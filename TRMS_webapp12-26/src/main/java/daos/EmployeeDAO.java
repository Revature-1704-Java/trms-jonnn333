package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import the_beans.Employee;
import util.ConnectionUtility;


public class EmployeeDAO implements EmployeeDAO_Interface {
	
	PreparedStatement ps = null;
	Employee EmployeeObject = null;
	ResultSet rs = null;
	// get all Employee info
	public List<Employee> getAllEmployees() {
		List<Employee> EmployeesList = new ArrayList<Employee>();
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM Employee";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				// not going to store ALL columns, despite using select-all SQL query 
				String id = rs.getString("Employee_ID");
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String supervisorID = rs.getString("SupervisorID");
				// int employeeTypeID = rs.getInt("employeeTypeID"); // int cannot accept null
				//System.out.println("information to be loaded: "+id+" | "+last+" | "+ email + " | " + password
				//		+ " | " + supervisorID);
				
				EmployeeObject = new Employee(id, first, last, email, password, supervisorID);
				EmployeesList.add(EmployeeObject);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return EmployeesList;
	}
	
	// get one particular employee's info (no password)
	public Employee getEmployee(String eid) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, eid);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String supervisorID = rs.getString("SupervisorID");
				
				EmployeeObject = new Employee(id, first, last, email, password, supervisorID);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return EmployeeObject;
	}
	
}
