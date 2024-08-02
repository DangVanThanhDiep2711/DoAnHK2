package entity;

public class Role {
	private int roleId;
	private String roleName;
	private boolean status;
	
	public Role() {}
	
	public Role(int roleId, String roleName, boolean status) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", status=" + status + "]";
	}
	
	
	
	
	
}
