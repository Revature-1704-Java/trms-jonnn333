package the_beans;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class Reimburse implements Serializable {

	//private double standardLimit = 1000.00;
	//private File documents = null;
	private int reimbursementID;
	private String employee_ID;
	private Date supApprove;
	private Date deptHeadApprove;
	private Date classStartDate;
	private String description;
	private double ReimbursementCost;
	private double ReimbursementAward;
	private int gradeFormatId;
	private String format;
	private String defaultPassingGrade;
	private int eventTypeID;
	private String eventType;
	private Double cover;
	private String event_Justify;
	private Blob attachment;
	private Blob approvalDocument;
	private int status;
	private int timeMissed;
	private String denyReason;

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

	public Date getClassStartDate() {
		return classStartDate;
	}

	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Double getCover() {
		return cover;
	}

	public void setCover(Double cover) {
		this.cover = cover;
	}

	public String getEvent_Justify() {
		return event_Justify;
	}

	public void setEvent_Justify(String event_Justify) {
		this.event_Justify = event_Justify;
	}

	public Blob getAttachment() {
		return attachment;
	}

	public void setAttachment(Blob attachment) {
		this.attachment = attachment;
	}

	public Blob getApprovalDocument() {
		return approvalDocument;
	}

	public void setApprovalDocument(Blob approvalDocument) {
		this.approvalDocument = approvalDocument;
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

	
	Reimburse () {
		// empty constructor!
	}
	
	
	
}
