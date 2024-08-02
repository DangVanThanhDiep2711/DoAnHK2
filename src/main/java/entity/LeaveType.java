package entity;

public class LeaveType {
	private int LeaveTypeID;
	private String LeaveTypeName;
	private String LeaveTypeDescription;
	private int LeaveDaysPerYear;
	private Boolean Status;
	
	public LeaveType() {}
	
	
	public LeaveType(int leaveTypeID, String leaveTypeName, String leaveTypeDescription, int leaveDaysPerYear,
			Boolean status) {
		super();
		LeaveTypeID = leaveTypeID;
		LeaveTypeName = leaveTypeName;
		LeaveTypeDescription = leaveTypeDescription;
		LeaveDaysPerYear = leaveDaysPerYear;
		Status = status;
	}


	public int getLeaveTypeID() {
		return LeaveTypeID;
	}


	public void setLeaveTypeID(int leaveTypeID) {
		LeaveTypeID = leaveTypeID;
	}


	public String getLeaveTypeName() {
		return LeaveTypeName;
	}


	public void setLeaveTypeName(String leaveTypeName) {
		LeaveTypeName = leaveTypeName;
	}


	public String getLeaveTypeDescription() {
		return LeaveTypeDescription;
	}


	public void setLeaveTypeDescription(String leaveTypeDescription) {
		LeaveTypeDescription = leaveTypeDescription;
	}


	public int getLeaveDaysPerYear() {
		return LeaveDaysPerYear;
	}


	public void setLeaveDaysPerYear(int leaveDaysPerYear) {
		LeaveDaysPerYear = leaveDaysPerYear;
	}


	public Boolean getStatus() {
		return Status;
	}


	public void setStatus(Boolean status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "LeaveType [LeaveTypeID=" + LeaveTypeID + ", LeaveTypeName=" + LeaveTypeName + ", LeaveTypeDescription="
				+ LeaveTypeDescription + ", LeaveDaysPerYear=" + LeaveDaysPerYear + ", Status=" + Status + "]";
	}
	
	
	
}
