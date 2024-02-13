package mobiles;

public class Admin {
	private int adminId;
	private String adminEmail;
	private String adminName;
	private String adminRole;
	private String adminPassword;
	
	
	public Admin(int adminId, String adminEmail, String adminName, String role, String password) {
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.adminRole = role;
		this.adminPassword = password;
	}
	

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String role) {
		this.adminRole = role;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String password) {
		this.adminPassword = password;
	}
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminName=" + adminName + ", adminRole="+ adminRole + ", adminPassword=" + adminPassword + "]";
	}
}