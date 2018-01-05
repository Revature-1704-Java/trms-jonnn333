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
			System.out.println("EmployeeDAO method getAllEmployees() called; query executed"); 
			
			while (rs.next()) {
				// not going to store ALL columns, despite using select-all SQL query 
				System.out.println("loading an employee...");

				int id = rs.getInt("Employee_ID"); System.out.println("employeeID..."); // guaranteed to have
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name"); 
				String email = rs.getString("Email"); 
				String password = rs.getString("Password"); 
				int supervisorID = rs.getInt("supervisorID"); 
				int deptHeadID = rs.getInt("Dept_HeadID"); 
				int EmployeeTypeID = rs.getInt("EmployeeType_ID"); 
			
				// int employeeTypeID = rs.getInt("employeeTypeID"); 
				
				EmployeeObject = new Employee(id, first, last, email, password, supervisorID, deptHeadID, EmployeeTypeID);
				
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
	public Employee getEmployee(Integer eid) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Integer id = rs.getInt("Employee_ID");
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				Integer supervisorID = rs.getInt("SupervisorID");
				Integer deptHeadID = rs.getInt("Dept_HeadID");
				Integer EmployeeTypeID = rs.getInt("EmployeeType_ID");
				
				EmployeeObject = new Employee(id, first, last, email, password, supervisorID, deptHeadID, EmployeeTypeID);
				
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


	// authentication only; no Employee objects returned
	public boolean isValidEmployee(String email_toVerify, String password_toVerify) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM Employee WHERE Email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email_toVerify);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("Employee_ID");
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				int supervisorID = rs.getInt("SupervisorID");
				int deptHeadID = rs.getInt("Dept_HeadID");
				int EmployeeTypeID = rs.getInt("EmployeeType_ID");
				
				if (email_toVerify.equals(email) && password_toVerify.equals(password)) {
					//EmployeeObject = new Employee(id, first, last, email, password, supervisorID, deptHeadID, EmployeeTypeID);
					return true;
				}
				
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
		return false;
	}
	
}
