package entity;

public class Employees {
	private int employeeID; 
	private String employeeName; 
	private String email;
	private String password;
	private boolean status;
	
	public Employees() {}

	public Employees(int employeeID, String employeeName, String email, String password, boolean status) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
	
		this.status = status;
		
	}
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employees [employeeID=" + employeeID + ", employeeName=" + employeeName + ", email=" + email
				+ ", password=" + password + ", status=" + status + "]";
	}


	

	
	
	


	
}
