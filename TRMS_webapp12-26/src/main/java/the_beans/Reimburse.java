package the_beans;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class Reimburse implements Serializable {

	double standardLimit = 1000.00;
	File documents = null;
	
	private int reimbursementID;
	private String employeeID;
	private String supervisorID;
	private String departmentHeadID;
	private String benCoID;
	private int approval;
	private Date employeeCreationDate;
	private Timestamp employeeCreationTime;
	private Date supervisorApproveDate;
	private Date departmentHeadApproveDate;
	private int reimbursementLocationId;
	private Date startDate;
	private String address;
	private String city;
	private String zip;
	private String country;
	private String description;
	private double cost;
	private double adjustedCost;
	private int gradeFormatId;
	private String format;
	private String defaultPassingGrade;
	private int eventTypeId;
	private String eventType;
	private Double coverage;
	private String workJustification;
	private Blob attachment;
	private Blob approvalDocument;
	private int approvalId;
	private String status;
	private int timeMissed;
	private String denyReason;
	private String inflatedReimbursementReason;
	
	Reimburse () {
		// empty constructor!
	}
	
	
	
}
