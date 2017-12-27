package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TRMS_webApp.BenCo;
import TRMS_webApp.ConnectionUtility;

public class BenCoDAO {

	public List<BenCo> getAllEmployees() {
		PreparedStatement ps = null;
		BenCo ben = null;
		List<BenCo> bencoList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Employee, EmployeeType WHERE EmployeeType = ";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String reportsTo = rs.getString("reportsTo");
				
				ben = new BenCo(id, first, last, reportsTo, reportsTo);
				bencoList.add(ben);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return bencoList;
	}
	
	public BenCo getEmployee(String req_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BenCo ben = null;
		try(Connection conn = ConnectionUtility.getConnection()) {
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
				
				ben = new BenCo(id, first, last, reportsTo, reportsTo);
				
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
		return ben;
	}
}
