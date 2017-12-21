package com.Revature.TRMS;

public class Reimburse {

	String eid;
	double requestAmount;
	double reimburseLimit;
	double standardLimit = 1000.00;
	boolean didBencoOverride = false;
	
	Reimburse (String eid, double reqAmt, double limit) {
		this.eid = eid;
		this.reimburseLimit = limit;
		this.requestAmount = reqAmt;
	}
	
	Reimburse () {
		// empty constructor!
	}
	
	public double getReimburseLimit() {
		return reimburseLimit;
	}
	public void setReimburseLimit(double reimburseLimit) {
		this.reimburseLimit = reimburseLimit;
	}
	public double getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}
	
	
}
