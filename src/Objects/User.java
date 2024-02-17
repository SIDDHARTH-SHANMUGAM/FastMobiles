package Objects;

public class User {
	public static int noOfUser = 0;
	
	private int userId;
	private String userName;
	private String userMobileNo;
	private String userAddress;
	private String userPassword;
	

	public User(int userId, String userName, String userMobileNo, String userAddress, String password) {
		this.userId = userId;
		this.userName = userName;
		this.userMobileNo = userMobileNo;
		this.userAddress = userAddress;
		this.userPassword = password;
	}
	public User(String userName, String userMobileNo, String userAddress, String password) {
		this.userName = userName;
		this.userMobileNo = userMobileNo;
		this.userAddress = userAddress;
		this.userPassword = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String password) {
		this.userPassword = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMobileNo="
				+ userMobileNo + ", userAddress=" + userAddress 
				+ ", password=" + userPassword + "]";
	}
	
	

}
