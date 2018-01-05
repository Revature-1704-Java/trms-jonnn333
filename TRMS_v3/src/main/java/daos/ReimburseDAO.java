package daos;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import the_beans.Employee;
import the_beans.Reimburse;
import util.ConnectionUtility;

public class ReimburseDAO implements ReimburseDAO_Inferface {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Reimburse ReimburseObject = null;
	
	// get all Reimbursements and accompanying info
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
				int employeeID = rs.getInt("Employee_ID");
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
	public Reimburse getReimbursement(String eid) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM Reimbursements WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, eid);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int reimburseID = rs.getInt("Reimbursement_ID");
				int employeeID = rs.getInt("Employee_ID");
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

	public String findGradeFormatByID(int gradeID) {
		
		String gradeFormat = null;
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM GradingFormat WHERE GradeFormat_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gradeID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				gradeFormat = rs.getString("GradeFormat_Type");
				
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
		if (gradeFormat == null) {gradeFormat = "C"; /*default grade if nothing is retrieved from resultset*/ }
		return gradeFormat;
	}

	public ArrayList<File> findRelevantFiles(int reimburseID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean ApproveReimbursement(int employeeID, int reimburseID, String reason, int status) {
		
		//Update Customer Set firstname = 'Robert', lastname = 'Walter' 
		//		where firstname = 'Aaron' and lastname = 'Mitchell';
		
		// available = total(1000) - pending - awarded
		Double availableReimbursement = 0.0;
		Double totalReimbursement = 1000.00;
		Double pendingReimbursements = 0.0;
		Double awardedReimbursements = 0.0;
		
		Double reimburseCost = 0.0;
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			String sql = "SELECT ReimbursementCost FROM Reimbursements WHERE reimbursement_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reimburseID);
			
			rs = ps.executeQuery();
			
			// 1 result
			while (rs.next()) {
				reimburseCost = rs.getDouble("ReimbursementCost");
			}
			
			// get the pending and awarded reimbursements for employee
			String sql2 = "SELECT SUM(r.ReimbursementAward) as awaredReimburse, SUM(r.ReimbursementCost) as pendingReimburse "
					+ "FROM Reimbursements r WHERE reimbursementID <> ?"
					+ "AND r.employee_ID = ?";
			ps.setInt(1, reimburseID);
			ps.setInt(2, employeeID);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pendingReimbursements = rs.getDouble("pendingReimburse");
				awardedReimbursements = rs.getDouble("awardedReimburse");
			}
			
			availableReimbursement = totalReimbursement - pendingReimbursements - awardedReimbursements;
			
			if (reimburseCost <= availableReimbursement) {
				
				Date prepDate = getTodaysDate(); 
				
				/*
			    Calendar calendar = Calendar.getInstance();
			    int month = calendar.get(calendar.MONTH);
			    int day = calendar.get(calendar.DAY_OF_WEEK);
			    int year = calendar.get(calendar.YEAR);
			    */
				
				String sql3 = "Update Reimbursements SET reimburseCost = 0, awardedReimbursements = ?, supApprove = ?, status = ? ";
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

	public Date getTodaysDate() {
		java.util.Date todaysDate = new java.util.Date();
		return new Date(todaysDate.getTime());
	}

	public boolean DenyReinbursement(int reimburseID, String deniedReason, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ReqestAddlDoc(int reimburseID, String reason, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	public double calculateReimbursement(Reimburse reimburseEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void autoApprove(int reimburseID, String autoReason, int status) {
		// TODO Auto-generated method stub
		
	}

	public void insertReimbursement(Reimburse reimburseEntry) {
		
		try {
			Connection conn = ConnectionUtility.getConnection();
			
			String sql = "INSERT INTO Reimbursements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " // 13 ?
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?"; //10 ?
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimburseEntry.getReimbursementID());
			ps.setInt(2, reimburseEntry.getEmployee_ID());
			ps.setInt(3, reimburseEntry.getEventTypeID());
			ps.setString(4, reimburseEntry.getEventDescription());
			ps.setString(5, reimburseEntry.getEventAddress());
			ps.setString(6, reimburseEntry.getEventCity());
			ps.setString(7, reimburseEntry.getEventState());
			ps.setString(8, reimburseEntry.getEventCountry());
			ps.setString(9, reimburseEntry.getEventZipCode());
			ps.setString(10, reimburseEntry.getEvent_Justification());
			ps.setInt(11, reimburseEntry.getGradeFormatId());
			ps.setDate(12, reimburseEntry.getClassStartDate()); // cannot cast sql date to java date and vice versa...fix front-end
			ps.setDouble(13, reimburseEntry.getReimbursementCost());
			ps.setDouble(14, reimburseEntry.getReimbursementAward());
			ps.setDate(15, reimburseEntry.getSubmission());
			ps.setInt(16, reimburseEntry.getTimeMissed());
			ps.setInt(17, reimburseEntry.getStatus());
			ps.setDouble(18, reimburseEntry.getExceedsAmount());
			ps.setString(19, reimburseEntry.getExceedsReason());
			ps.setString(20, reimburseEntry.getDenyReason());
			ps.setDate(21, reimburseEntry.getSupApprove());
			ps.setDate(22, reimburseEntry.getDeptHeadApprove());
			ps.setDate(23, reimburseEntry.getBenCoApprove());			
			
			rs = ps.executeQuery();
			
			
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
		
		System.out.println("reimbursement inserted...I think. Check.");
		
	}
		
		// reasons for denial, request additional documents, or explain why approval amount exceeds limit
		// do valid checks for inputs
		// deny, set reason
		
		// reimburseID (unique)
		// do valid checks for inputs
		// requestAddl Docs

		/* supervisor, head dept., or benco can modify */
		// adjust to $1000 limit and approve
		// modify
		
		// approve; check to see if it is within the $1000 limit for employee
		
	

	

		
}
