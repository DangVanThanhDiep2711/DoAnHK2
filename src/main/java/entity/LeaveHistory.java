package entity;

import java.util.Date;

public class LeaveHistory {
	private int historyId; 
	private int employeeId; 
	private String leaveType;
	private Date startDate;
	private Date endDate; 
	private String reason; 
	private String approvalStatus;
	private int approverID;
	private Date submissionDate;
	private Date approvalDate;
	private Boolean status;
	
	public LeaveHistory() {}

	public LeaveHistory(int historyId, int employeeId, String leaveType, Date startDate, Date endDate, String reason,
			String approvalStatus, int approverID, Date submissionDate, Date approvalDate, Boolean status) {
		super();
		this.historyId = historyId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.approvalStatus = approvalStatus;
		this.approverID = approverID;
		this.submissionDate = submissionDate;
		this.approvalDate = approvalDate;
		this.status = status;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getApproverID() {
		return approverID;
	}

	public void setApproverID(int approverID) {
		this.approverID = approverID;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeaveHistory [historyId=" + historyId + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason + ", approvalStatus="
				+ approvalStatus + ", approverID=" + approverID + ", submissionDate=" + submissionDate
				+ ", approvalDate=" + approvalDate + ", status=" + status + "]";
	}
	
	
	
	
	
}
