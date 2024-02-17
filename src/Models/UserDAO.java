package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Objects.User;

public class UserDAO {

	PreparedStatement pstmt;
	String query;
	
	
	public boolean addNewUser(User userObject)
	{
		query = "INSERT INTO user( userName, userMobileNo, userAddress, userPassword) VALUES( ?, ?, ?, ?)";
		
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, userObject.getUserName());
			pstmt.setString(2, userObject.getUserMobileNo());
			pstmt.setString(3, userObject.getUserAddress());
			pstmt.setString(4, userObject.getUserPassword());
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
	
	public User getUserByMobileNo(String userMobileNo)
	{
		query = "SELECT * FROM user WHERE userMobileNo = ? ";
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, userMobileNo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
			{
                return new User(rs.getInt("userId"), rs.getString("userName"), userMobileNo,  rs.getString("userAddress"), rs.getString("userPassword"));
			}
		} catch (SQLException e) {
			System.out.println("Validating Error\n"+e);
		}
		return null;
	}
	public boolean isUserMobileNoAvailable(String userMobileNo)
	{
		query = "SELECT * FROM user WHERE userMobileNo = ? ";
	
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, userMobileNo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			System.out.println("DB ERROR\n"+e);
		}
		return false;
	}
}
