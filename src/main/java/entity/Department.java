package entity;

public class Department {
	private int departmentId;
	private String departmentName;
	private boolean status;
	
	public Department() {}
	
	
	public Department(int departmentId, String departmentName, boolean status) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.status = status;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", status=" + status
				+ "]";
	}
	
	
	
	
}
