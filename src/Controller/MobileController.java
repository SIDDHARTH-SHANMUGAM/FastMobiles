package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Model.Mobile;

public class MobileController {
	PreparedStatement pstmt;
	String query;
	
	public boolean addMobile(Mobile mobileObject)
	{
		query = "INSERT INTO mobile( mobileModel,mobileBrand,mobileRam,mobileRom, mobileProcessor, mobileBattery, mobileCamera, mobileConnectivities, mobileGPS, mobileDisplay, mobileDimensions, mobilePrice, availableColors, attachments, availableInStack) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		try {
			pstmt = Db.getPs(query);
			pstmt.setString(1, mobileObject.getMobileModel());
			pstmt.setString(2, mobileObject.getMobileBrand());
			pstmt.setInt(3, mobileObject.getMobileRam());
			pstmt.setInt(4, mobileObject.getMobileRom());
			pstmt.setString(5, mobileObject.getMobileProcessor());
			pstmt.setInt(6, mobileObject.getMobileBattery());
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
	        pstmt = Db.getPs(query);
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
			pstmt = Db.getPs(query);
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
	        pstmt = Db.getPs(query);
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
	public List<Mobile> getAllMobiles()
	{
		List<Mobile> listOfMobiles = new ArrayList<>();
		query = "SELECT * FROM mobile";
		try {
			pstmt = Db.getPs(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				listOfMobiles.add( new Mobile(
						rs.getInt("mobileId"),
						rs.getString("mobileModel"),
						rs.getString("mobileBrand"),
						rs.getInt("mobileRam"),
						rs.getInt("mobileRom"),
						rs.getString("mobileProcessor"),
						rs.getInt("mobileBattery"),
						rs.getString("mobileCamera"),
						rs.getString("mobileConnectivities"),
						rs.getString("mobileGPS"),
						rs.getString("mobileDisplay"),
						rs.getString("mobileDimensions"),
						rs.getInt("mobilePrice"),
						rs.getString("availableColors"),
						rs.getString("attachments"),
						rs.getInt("availableInStack")
						));
				
				
			}
			return listOfMobiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Mobile getMobileByMobileId(int mobileId)
	{
		query = "SELECT * FROM mobile where mobileId = ?";
		try {
			pstmt = Db.getPs(query);
			pstmt.setInt(1, mobileId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return new Mobile(
						rs.getInt("mobileId"),
						rs.getString("mobileModel"),
						rs.getString("mobileBrand"),
						rs.getInt("mobileRam"),
						rs.getInt("mobileRom"),
						rs.getString("mobileProcessor"),
						rs.getInt("mobileBattery"),
						rs.getString("mobileCamera"),
						rs.getString("mobileConnectivities"),
						rs.getString("mobileGPS"),
						rs.getString("mobileDisplay"),
						rs.getString("mobileDimensions"),
						rs.getInt("mobilePrice"),
						rs.getString("availableColors"),
						rs.getString("attachments"),
						rs.getInt("availableInStack")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public int getMobilePrice( int mobileId) {
        int price = 0;
        query = "SELECT mobilePrice FROM mobile WHERE mobileId = ?";

        try{
        	pstmt = Db.getPs(query);
            pstmt.setInt(1, mobileId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getInt("mobilePrice");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return price;
    }
    
    public boolean isValidMobileId(int mobileId)
    {
    	query = "SELECT mobilePrice FROM mobile WHERE mobileId = ?";
    
    	try{
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, mobileId);
    		ResultSet resultSet = pstmt.executeQuery();
    		
    		if (resultSet.next()) {
    			return true;
    		}
    	} catch (SQLException | NumberFormatException e) {
    		System.out.println("Error: " + e.getMessage());
    	}
    	return false;
    }
    public int getAvailable(int mobileId)
    {
    	query = "SELECT availableInStack FROM mobile WHERE mobileId = ?";
    	
    	try{
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, mobileId);
    		ResultSet resultSet = pstmt.executeQuery();
    		
    		if (resultSet.next()) {
    			return resultSet.getInt("availableInStack");
    		}
    	} catch (SQLException | NumberFormatException e) {
    		System.out.println("Error: " + e.getMessage());
    	}
    	return -1;
    	
    }
    public boolean decreaseCount(int mobileId, int count)
    {
    	query = "UPDATE mobile SET availableInStack = availableInStack - ? WHERE mobileId = ?";
    	
    	try{
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, count);
    		pstmt.setInt(2, mobileId);
    		int rs = pstmt.executeUpdate();
    		
    		if (rs>0) {
    			return true;
    		}
    	} catch (SQLException | NumberFormatException e) {
    		System.out.println("Error: " + e.getMessage());
    	}
    	return false;
    }
    
}
