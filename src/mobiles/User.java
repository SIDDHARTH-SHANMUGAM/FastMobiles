package mobiles;

public class User {
	static int noOfUser = 0;
	
	private int userId;
	private String userEmail;
	private String userName;
	private String userMobileNo;
	private String userAddress;
	private long totalPurchaseAmount;
	private String userPassword;
	

	public User(int userId, String userEmail, String userName, String userMobileNo, String userAddress, long totalPurchaseAmount, String password) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userMobileNo = userMobileNo;
		this.userAddress = userAddress;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.userPassword = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public long getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(long totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String password) {
		this.userPassword = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userName=" + userName + ", userMobileNo="
				+ userMobileNo + ", userAddress=" + userAddress + ", totalPurchaseAmount=" + totalPurchaseAmount
				+ ", password=" + userPassword + "]";
	}
	
	

}
