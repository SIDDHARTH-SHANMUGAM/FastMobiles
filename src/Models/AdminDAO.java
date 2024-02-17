package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Objects.Admin;

public class AdminDAO {
	PreparedStatement pstmt;
	String query;
	
	public boolean addNewAdmin(Admin adminObject)
	{
		query = "INSERT INTO admin( adminMobileNo, adminName, adminRole, adminPassword) VALUES( ?, ?, ?, ? )";
		
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, adminObject.getAdminMobileNo());
			pstmt.setString(2, adminObject.getAdminName());
			pstmt.setString(3, adminObject.getAdminRole());
			pstmt.setString(4, adminObject.getAdminPassword());
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
		} catch (SQLException e) {
			System.out.println("AdminController--adminInsertionError\n"+e);
		}
		return false;
	}
	public Admin getAdminByMobileNo(String adminMobileNo)
	{
		query = "SELECT * FROM admin WHERE adminMobileNo = ? ";
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, adminMobileNo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
			{
				return new Admin(rs.getInt("adminId"), adminMobileNo, rs.getString("adminName"), rs.getString("adminRole"), rs.getString("adminPassword"));
			}
		} catch (SQLException e) {
			System.out.println("AdminController--gettingAdminByMobileNo\n"+e);
		}
		return null;
	}
	public boolean isAdminMobileNoAvailable(String adminMobileNo)
	{
		query = "SELECT * FROM admin WHERE adminMobileNo = ? ";
		
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, adminMobileNo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			System.out.println("AdminController--isAdminMobileAvailable\n"+e);
		}
		return false;
	}
}
