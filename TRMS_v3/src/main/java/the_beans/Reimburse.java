package the_beans;

import java.io.File;
import java.io.Serializable;
//import java.sql.Blob;
import java.sql.Date;

public class Reimburse implements Serializable {

	// for Serialization/deserialization
	private static final long serialVersionUID = 2169986389192045924L;
	//---------------------------------------------------------------------------------------------
	private File documents = null; // retrieve files from system after finding index in db
	private int reimbursementID;
	private String employee_ID;
	private Date classStartDate;
	private String eventDescription;
	private String eventAddress;
	private String eventCity;
	private String eventState;
	private String eventCountry;
	private String eventZipCode;
	private double ReimbursementCost;
	private double ReimbursementAward;
	private int gradeFormatId;
	private String gradeFormat;
	private int eventTypeID;
	private String event_Justification;
	private int status; // hold values to determine status (level of approval, requesting documents, benco approve etc.)
	private int timeMissed;
	private String denyReason;
	private Date submission;
	private Double exceedsAmount;
	private String exceedsReason;
	//---------------------------------------------------------------------------------------------
	// variables to be retrieved later, or filled null by default
	// note: Date variable type can accept null value
	private String defaultPassingGrade = "C"; // using A-F grade system, default
	private Date supApprove; // status, as well as date of approval separate column
	private Date deptHeadApprove; // status, as well as date of approval separate column
	private Date benCoApprove; // status, as well as date of approval in separate column
	
	// thinking of using, if foregoing File system
	//private Blob attachment; //ah - same as below??? 
	//private Blob approvalDocument; //do I need this as an intermediary?
	
	// to be retrieved by using eventTypeID to reference event type on table
	private String eventType;	
	//---------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------
	
	public Reimburse (int reimbursementID, String employeeID, int EventID, 
			String eventDescription, String eventAddress, String eventCity, String eventState,
			String eventCountry, String eventZipCode, String justification, int gradeFormatID,
			Date eventTime, double reimburseCost, double reimburseAward, Date submission, 
			int timeMissed, int Status, double exceedsAmount, String exceedsReason, String denyReason, 
			Date supApprove, Date deptHeadApprove, Date benCoApprove) {
		
		// location -- break down further in ERD and in db: address, city, state, zip, country, etc.
		
		this.reimbursementID = reimbursementID;
		this.employee_ID = employeeID;
		this.eventTypeID = EventID;
		this.eventDescription = eventDescription;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventCountry = eventCountry;
		this.eventZipCode = eventZipCode;
		this.event_Justification = justification;
		this.gradeFormatId = gradeFormatID;
		this.classStartDate = eventTime;
		this.ReimbursementCost = reimburseCost;
		this.ReimbursementAward = reimburseAward;
		this.submission = submission;
		this.timeMissed = timeMissed;
		this.status = Status; // status changes depending on approvals/request documents - make one up, each level
		this.exceedsAmount = exceedsAmount;// exceeds amount -- can I just do a check/calculation method in java?
		this.exceedsReason = exceedsReason;// exceeds reason -- hmm...where can I put this?
		this.denyReason = denyReason;
		
		this.supApprove = supApprove;
		this.deptHeadApprove = deptHeadApprove;
		this.benCoApprove = benCoApprove;
	}


	public File getDocuments() {
		return documents;
	}


	public void setDocuments(File documents) {
		this.documents = documents;
	}


	public int getReimbursementID() {
		return reimbursementID;
	}


	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}


	public String getEmployee_ID() {
		return employee_ID;
	}


	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
	}


	public Date getClassStartDate() {
		return classStartDate;
	}


	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}


	public String getEventDescription() {
		return eventDescription;
	}


	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public String getEventAddress() {
		return eventAddress;
	}


	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}


	public String getEventCity() {
		return eventCity;
	}


	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}


	public String getEventState() {
		return eventState;
	}


	public void setEventState(String eventState) {
		this.eventState = eventState;
	}


	public String getEventCountry() {
		return eventCountry;
	}


	public void setEventCountry(String eventCountry) {
		this.eventCountry = eventCountry;
	}


	public String getEventZipCode() {
		return eventZipCode;
	}


	public void setEventZipCode(String eventZipCode) {
		this.eventZipCode = eventZipCode;
	}

	public double getReimbursementCost() {
		return ReimbursementCost;
	}


	public void setReimbursementCost(double reimbursementCost) {
		ReimbursementCost = reimbursementCost;
	}


	public double getReimbursementAward() {
		return ReimbursementAward;
	}


	public void setReimbursementAward(double reimbursementAward) {
		ReimbursementAward = reimbursementAward;
	}


	public int getGradeFormatId() {
		return gradeFormatId;
	}


	public void setGradeFormatId(int gradeFormatId) {
		this.gradeFormatId = gradeFormatId;
	}


	public String getGradeFormat() {
		return gradeFormat;
	}


	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	public String getDefaultPassingGrade() {
		return defaultPassingGrade;
	}


	public void setDefaultPassingGrade(String defaultPassingGrade) {
		this.defaultPassingGrade = defaultPassingGrade;
	}


	public int getEventTypeID() {
		return eventTypeID;
	}


	public void setEventTypeID(int eventTypeID) {
		this.eventTypeID = eventTypeID;
	}


	public String getEvent_Justification() {
		return event_Justification;
	}


	public void setEvent_Justification(String event_Justification) {
		this.event_Justification = event_Justification;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getTimeMissed() {
		return timeMissed;
	}


	public void setTimeMissed(int timeMissed) {
		this.timeMissed = timeMissed;
	}


	public String getDenyReason() {
		return denyReason;
	}


	public void setDenyReason(String denyReason) {
		this.denyReason = denyReason;
	}


	public Date getSubmission() {
		return submission;
	}


	public void setSubmission(Date submission) {
		this.submission = submission;
	}


	public Date getSupApprove() {
		return supApprove;
	}


	public void setSupApprove(Date supApprove) {
		this.supApprove = supApprove;
	}


	public Date getDeptHeadApprove() {
		return deptHeadApprove;
	}


	public void setDeptHeadApprove(Date deptHeadApprove) {
		this.deptHeadApprove = deptHeadApprove;
	}


	public Date getBenCoApprove() {
		return benCoApprove;
	}


	public void setBenCoApprove(Date benCoApprove) {
		this.benCoApprove = benCoApprove;
	}


	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public Double getExceedsAmount() {
		return this.exceedsAmount;
	}
	
	public void setExceedsAmount(Double exceedsAmount) {
		this.exceedsAmount = exceedsAmount;
	}
	
	public String getExceedsReason() {
		return this.exceedsReason;
	}
	
	public void setExceedsReason(String exceedsReason) {
		this.exceedsReason = exceedsReason;
	}
	
	@Override
	public String toString() {
		return "Reimburse [documents=" + documents + ", reimbursementID=" + reimbursementID + ", employee_ID="
				+ employee_ID + ", classStartDate=" + classStartDate + ", eventDescription=" + eventDescription
				+ ", eventAddress=" + eventAddress + ", eventCity=" + eventCity + ", eventState=" + eventState
				+ ", eventCountry=" + eventCountry + ", eventZipCode=" + eventZipCode + ", ReimbursementCost="
				+ ReimbursementCost + ", ReimbursementAward=" + ReimbursementAward + ", gradeFormatId=" + gradeFormatId
				+ ", gradeFormat=" + gradeFormat + ", eventTypeID=" + eventTypeID + ", event_Justification="
				+ event_Justification + ", status=" + status + ", timeMissed=" + timeMissed + ", denyReason="
				+ denyReason + ", submission=" + submission + ", exceedsAmount=" + exceedsAmount + ", exceedsReason="
				+ exceedsReason + ", defaultPassingGrade=" + defaultPassingGrade + ", supApprove=" + supApprove
				+ ", deptHeadApprove=" + deptHeadApprove + ", benCoApprove=" + benCoApprove + ", eventType=" + eventType
				+ "]";
	}

	
}
