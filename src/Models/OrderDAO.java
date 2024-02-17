package Models;

import java.sql.PreparedStatement;
import java.util.*;

import Objects.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
	PreparedStatement pstmt;
	String query;
		
	public List<Order> getOrdersById(int orderId)
	{
		List<Order> listOfOrders = new ArrayList<>();
		query = "SELECT * FROM ordert WHERE orderId = ? ";
    	try {
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, orderId);
    		ResultSet rs = pstmt.executeQuery();
    		while(rs.next())
    		{
    			listOfOrders.add( new Order(
    					rs.getInt("orderId"),
    					rs.getInt("mobileId"),
    					rs.getInt("count")
    					));
    		}
    		return listOfOrders;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
		
	}
	public boolean addOrder(Order orderObject)
	{
		query = "Insert into orderT(orderId, mobileId, count) values(?, ?, ?)";
		try {
			PreparedStatement pstmt = Db.getPs(query);
			pstmt.setInt(1, orderObject.getOrderId());
			pstmt.setInt(2, orderObject.getMobileId());
			pstmt.setInt(3, orderObject.getCount());
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("Error"+ e);
		}
		return false;
	}
	public boolean removeOrder(int orderId)
	{
		String query = "Delete from orderT where orderId= ?";
		try {
			PreparedStatement pstmt = Db.getPs(query);
			pstmt.setInt(1, orderId);
			byte res = (byte) pstmt.executeUpdate();
			if(res>(byte)0)
			{
				return true;
			}
			
		}
		catch (Exception e) {
			System.out.println("Error"+ e);
		}
		return false;
		
	}

}
