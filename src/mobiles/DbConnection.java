package mobiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	Connection con;
	PreparedStatement pstmt;
	String query;
	
// get Connection
	public void getMSMDbconnection() 
	{
		String url="jdbc:mysql://localhost:3306/MSM";
		String userName="root";
		String password="";
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println("DB CONNECTION ERROR\n"+e);
		}
		return;
	}
//user controller
	public boolean addNewUser(User userObject)
	{
		query = "INSERT INTO user( userEmail, userName, userMobileNo, userAddress, totalPurchaseAmount, userPassword) VALUES( ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userObject.getUserEmail());
			pstmt.setString(2, userObject.getUserName());
			pstmt.setString(3, userObject.getUserMobileNo());
			pstmt.setString(4, userObject.getUserAddress());
			pstmt.setLong(5, userObject.getTotalPurchaseAmount());
			pstmt.setString(6, userObject.getUserPassword());
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
		} catch (SQLException e) {
			System.out.println("DB User INSERT ERROR\n"+e);
		}
		return false;
	}
	
	public User getUserByEmail(String userEmail)
	{
		query = "SELECT * FROM user WHERE userEmail = ? ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
			{
                return new User(rs.getInt("userId"), userEmail, rs.getString("userName"), rs.getString("userMobileNo"), rs.getString("userAddress"), rs.getLong("totalPurchaseAmount"), rs.getString("userPassword"));
			}
		} catch (SQLException e) {
			System.out.println("DB INSERTION ERROR\n"+e);
		}
		return null;
	}
	public boolean isUserEmailAvailable(String userEmail)
	{
		query = "SELECT * FROM user WHERE userEmail = ? ";
	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			System.out.println("DB ERROR\n"+e);
		}
		return false;
	}
//admin controller
	public boolean addNewAdmin(Admin adminObject)
	{
		query = "INSERT INTO admin( adminEmail, adminName, adminRole, adminPassword) VALUES( ?, ?, ?, ? )";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminObject.getAdminEmail());
			pstmt.setString(2, adminObject.getAdminName());
			pstmt.setString(3, adminObject.getAdminRole());
			pstmt.setString(4, adminObject.getAdminPassword());
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
		} catch (SQLException e) {
			System.out.println("DB User INSERT ERROR\n"+e);
		}
		return false;
	}
	public Admin getAdminByEmail(String adminEmail)
	{
		query = "SELECT * FROM admin WHERE adminEmail = ? ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminEmail);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
			{
				return new Admin(rs.getInt("adminId"), adminEmail, rs.getString("adminName"), rs.getString("adminRole"), rs.getString("adminPassword"));
			}
		} catch (SQLException e) {
			System.out.println("DB INSERTION ERROR\n"+e);
		}
		return null;
	}
	public boolean isAdminEmailAvailable(String adminEmail)
	{
		query = "SELECT * FROM admin WHERE adminEmail = ? ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminEmail);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			System.out.println("DB ERROR\n"+e);
		}
		return false;
	}
	
// Mobile Controller
	public boolean addMobile(Mobile mobileObject)
	{
		query = "INSERT INTO mobile( mobileModel,mobileBrand,mobileRam,mobileRom, mobileProcessor, mobileBattery, mobileCamera, mobileConnectivities, mobileGPS, mobileDisplay, mobileDimensions, mobilePrice, availableColors, attachments, availableInStack) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mobileObject.getMobileModel());
			pstmt.setString(2, mobileObject.getMobileBrand());
			pstmt.setString(3, mobileObject.getMobileRam());
			pstmt.setString(4, mobileObject.getMobileRom());
			pstmt.setString(5, mobileObject.getMobileProcessor());
			pstmt.setString(6, mobileObject.getMobileBattery());
			pstmt.setString(7, mobileObject.getMobileCamera());
			pstmt.setString(8, mobileObject.getMobileConnectivities());
			pstmt.setString(9, mobileObject.getMobileGPS());
			pstmt.setString(10, mobileObject.getMobileDisplay());
			pstmt.setString(11, mobileObject.getMobileDimensions());
			pstmt.setInt(12, mobileObject.getMobilePrice());
			pstmt.setString(13, mobileObject.getAvailableColors());
			pstmt.setString(14, mobileObject.getAttachments());
			pstmt.setInt(15, mobileObject.getAvailableInStack());
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
		} catch (SQLException e) {
			System.out.println("DB User INSERT ERROR\n"+e);
		}
		return false;
	}
	public boolean updateMobileCount(int mobileId, int currentCount) {
	    query = "UPDATE mobile SET availableInStack = ? WHERE mobileId = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, currentCount);
	        pstmt.setInt(2, mobileId);
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        System.out.println("DB Mobile UPDATE ERROR\n" + e);
	    }
	    return false;
	}
	public boolean updateAvaliableColors(int mobileId, String colors) {
		query = "UPDATE mobile SET availableColors = ? WHERE mobileId = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, colors);
			pstmt.setInt(2, mobileId);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("DB Mobile UPDATE ERROR\n" + e);
		}
		return false;
	}
	public boolean removeMobile(int mobileId) {
	    query = "DELETE FROM mobile WHERE mobileId = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, mobileId);
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        System.out.println("DB Mobile DELETE ERROR\n" + e);
	    }
	    return false;
	}

}