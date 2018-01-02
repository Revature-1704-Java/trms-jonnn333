package daos;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import the_beans.Reimburse;
import util.ConnectionUtility;

public class ReimburseDAO implements ReimburseDAO_Inferface {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Reimburse ReimburseObject = null;
	
	// get all Reimbursements and accompanying info
	@Override
	public List<Reimburse> getAllReimbursements() {
		List<Reimburse> ReimburseList = new ArrayList<Reimburse>();
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM Reimbursements";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				// going to store ALL columns, despite using select-all SQL query 
				int reimburseID = rs.getInt("Reimbursement_ID");
				String employeeID = rs.getString("Employee_ID");
				int eventID = rs.getInt("Event_ID");
				String eventDescription = rs.getString("Event_Description");
				String address = rs.getString("Event_Address");
				String city = rs.getString("Event_City");
				String state = rs.getString("Event_State");
				String country = rs.getString("Event_Country");
				String zipCode = rs.getString("Event_zipCode");
				String justification = rs.getString("Event_Justification");
				int gradeFormatID = rs.getInt("gradeFormatID");
				Date eventTime = rs.getDate("event_timeStamp");
				double reimburseCost = rs.getDouble("ReimbursementCost");
				double reimburseAward = rs.getDouble("ReimburseAward");
				Date submissionTime = rs.getDate("SubmissionTime");
				int timeMissed = rs.getInt("TimeMissed");
				int ReimburseStatus = rs.getInt("Status");
				double exceedsAmount = rs.getDouble("ExceedsAmount");
				String exceedsReason = rs.getString("ExceedsReason");
				String deniedReason = rs.getString("DeniedReason");
				Date supApproveTime = rs.getDate("SupApprove");
				Date deptHeadApproveTime = rs.getDate("deptHeadApprove");
				Date benCoApproveTime = rs.getDate("benCoApprove");
				
				ReimburseObject = new Reimburse(reimburseID, employeeID, eventID, 
						eventDescription, address, city, state, 
						country, zipCode, justification, gradeFormatID,
						eventTime, reimburseCost, reimburseAward, submissionTime,
						timeMissed, ReimburseStatus, exceedsAmount, exceedsReason, deniedReason,
						supApproveTime, deptHeadApproveTime, benCoApproveTime);
				ReimburseList.add(ReimburseObject);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return ReimburseList;
	}
	
	// get specific employee's reimbursements and related info
	@Override
	public Reimburse getReimbursement(String eid) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM Reimbursements WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, eid);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int reimburseID = rs.getInt("Reimbursement_ID");
				String employeeID = rs.getString("Employee_ID");
				int eventID = rs.getInt("Event_ID");
				String eventDescription = rs.getString("Event_Description");
				String address = rs.getString("Event_Address");
				String city = rs.getString("Event_City");
				String state = rs.getString("Event_State");
				String country = rs.getString("Event_Country");
				String zipCode = rs.getString("Event_zipCode");
				String justification = rs.getString("Event_Justification");
				int gradeFormatID = rs.getInt("gradeFormatID");
				Date eventTime = rs.getDate("event_timeStamp");
				double reimburseCost = rs.getDouble("ReimbursementCost");
				double reimburseAward = rs.getDouble("ReimburseAward");
				Date submissionTime = rs.getDate("SubmissionTime");
				int timeMissed = rs.getInt("TimeMissed");
				int ReimburseStatus = rs.getInt("Status");
				double exceedsAmount = rs.getDouble("ExceedsAmount");
				String exceedsReason = rs.getString("ExceedsReason");
				String deniedReason = rs.getString("DeniedReason");
				Date supApproveTime = rs.getDate("SupApprove");
				Date deptHeadApproveTime = rs.getDate("deptHeadApprove");
				Date benCoApproveTime = rs.getDate("benCoApprove");
				
				ReimburseObject = new Reimburse(reimburseID, employeeID, eventID, 
						eventDescription, address, city, state, 
						country, zipCode, justification, gradeFormatID,
						eventTime, reimburseCost, reimburseAward, submissionTime,
						timeMissed, ReimburseStatus, exceedsAmount, exceedsReason, deniedReason,
						supApproveTime, deptHeadApproveTime, benCoApproveTime);
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
		return ReimburseObject;
	}

	@Override
	public String FindGradeFormatByID(int gradeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<File> findRelevantFiles(int reimburseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyReimburseLim(int reimburseID, String reason) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveReimburse(int reimburseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestAddlDocs(int reimburseID, int status, String reason) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setReason(int reimburseID, String reason) {
		// TODO Auto-generated method stub
		return false;
	}
		
}
