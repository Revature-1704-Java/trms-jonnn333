package daos;

import java.sql.ResultSet;

public class BenCoDAO {

	public List<BenCo> getAllEmployees() {
		PreparedStatement ps = null;
		BenCo ben = null;
		List<BenCo> Employees = new ArrayList<>();
		
		try(Connection conn = ConnectionDAO.getConnection()) {
			String sql = "SELECT * FROM BenefitsCoordinator";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String reportsTo = rs.getString("reportsTo");
				
				E = new ben(id, first, last, reportsTo);
				Employees.add(E);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return Employees;
	}
	
	public BenCo getEmployee(String req_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BenCo EA = null;
		try(Connection conn = ConnectionDAO.getConnection()) {
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM BenefitsCoordinator WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, req_id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				//int bid = rs.getInt("BEAR_ID");
				//String name = rs.getString("BEAR_NAME");
				//int age = rs.getInt("BEAR_AGE");
				//int weight = rs.getInt("BEAR_WEIGHT");
				
				//b = new Bear(bid, name, age, weight);
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String reportsTo = rs.getString("reportsTo");
				
				E = new ben(id, first, last, reportsTo);
				
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
