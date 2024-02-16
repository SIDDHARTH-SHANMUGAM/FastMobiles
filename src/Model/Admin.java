package Model;

public class Admin {
	private int adminId;
	private String adminMobileNo;
	private String adminName;
	private String adminRole;
	private String adminPassword;
	public Admin(int adminId, String adminMobileNo, String adminName, String adminRole, String adminPassword) {
		this.adminId = adminId;
		this.adminMobileNo = adminMobileNo;
		this.adminName = adminName;
		this.adminRole = adminRole;
		this.adminPassword = adminPassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminMobileNo() {
		return adminMobileNo;
	}
	public void setAdminMobileNo(String adminMobileNo) {
		this.adminMobileNo = adminMobileNo;
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
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminMobile=" + adminMobileNo + ", adminName=" + adminName
				+ ", adminRole=" + adminRole + ", adminPassword=" + adminPassword + "]";
	}
	
	
}