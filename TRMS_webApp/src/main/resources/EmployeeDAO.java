package com.Revature.TRMS;

import java.sql.ResultSet;

public class EmployeeDAO {
	
	public List<Employee> getAllEmployees() {
		PreparedStatement ps = null;
		Employee E = null;
		List<Employee> Employees = new ArrayList<>();
		
		try(Connection conn = ConnectionDAO.getConnection()) {
			String sql = "SELECT * FROM Employee";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String reportsTo = rs.getString("reportsTo");
				
				E = new Employee(id, first, last, reportsTo);
				Employees.add(E);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return Employees;
	}
	
	public Employee getEmployee(String req_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee EA = null;
		try(Connection conn = ConnectionDAO.getConnection()) {
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, req_id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String reportsTo = rs.getString("reportsTo");
				
				E = new Employee(id, first, last, reportsTo);
				
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
		return E;
	}
	
}
