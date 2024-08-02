package entity;

import java.util.Date;

public class LeaveRequests {
	private int leaveRequestId;
    private int employeeId;
    private String employeeName;
    private int leaveTypeId;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String statusLR;
    private int approverId;
    private Date submissionDate;
    private Date approvalDate;
    private boolean status;
	
    
    
	public LeaveRequests() {}

	
	public LeaveRequests(int leaveRequestId, int employeeId, String employeeName, int leaveTypeId, Date startDate,
			Date endDate, String reason, String statusLR, int approverId, Date submissionDate, Date approvalDate,
			boolean status) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.leaveTypeId = leaveTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.statusLR = statusLR;
		this.approverId = approverId;
		this.submissionDate = submissionDate;
		this.approvalDate = approvalDate;
		this.status = status;
	}


	public int getLeaveRequestId() {
		return leaveRequestId;
	}


	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public int getLeaveTypeId() {
		return leaveTypeId;
	}


	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
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


	public String getStatusLR() {
		return statusLR;
	}


	public void setStatusLR(String statusLR) {
		this.statusLR = statusLR;
	}


	public int getApproverId() {
		return approverId;
	}


	public void setApproverId(int approverId) {
		this.approverId = approverId;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "LeaveRequests [leaveRequestId=" + leaveRequestId + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", leaveTypeId=" + leaveTypeId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", reason=" + reason + ", statusLR=" + statusLR + ", approverId=" + approverId + ", submissionDate="
				+ submissionDate + ", approvalDate=" + approvalDate + ", status=" + status + "]";
	}

	
}
