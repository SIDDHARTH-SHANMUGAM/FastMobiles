package Controller;

import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Order;

public class OrderController {
	PreparedStatement pstmt;
	String query;
	
	public int getCurrentOrderId()
	{
		PreparedStatement ps = Db.getPs("select orderCount from counter");
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt("orderCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public boolean incOrderId(int curId)
	{
		PreparedStatement ps = Db.getPs("UPDATE counter SET orderCount = ?");
		try {
			ps.setInt(1, curId+1);
			byte rs =(byte) ps.executeUpdate();
			if(rs > 0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
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
