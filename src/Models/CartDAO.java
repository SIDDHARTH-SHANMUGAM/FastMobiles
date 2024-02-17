package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objects.Cart;

public class CartDAO {
	PreparedStatement pstmt;
	String query;
	
	public boolean addCart(Cart cartObject)
	{
		query = "INSERT INTO cart( mobileId, userId ) VALUES( ?, ? )";
		try {
			pstmt = Db.getPs(query);
			pstmt.setInt(1, cartObject.getMobileId());
			pstmt.setInt(2, cartObject.getUserId());
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
	public boolean isMobileInCart(int mobileId, int userId) {
	    query = "select * from cart where mobileId = ? and userId = ?";
	    try {
	        pstmt = Db.getPs(query);
	        pstmt.setInt(1, mobileId);
	        pstmt.setInt(2, userId);
	        ResultSet rs = pstmt.executeQuery();
	        if ( rs.next()) {
	            return true;
	        }
	    } catch (SQLException e) {
	        System.out.println("DB Mobile UPDATE ERROR\n" + e);
	    }
	    return false;
	}
	public int getCartById(int mobileId, int userId)
	{
		query = "select * from cart where mobileId = ? and userId = ?";
		try {
			pstmt = Db.getPs(query);
			pstmt.setInt(1, mobileId);
			pstmt.setInt(2, userId);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next()) {
				return rs.getInt("cartId");
			}
		} catch (SQLException e) {
			System.out.println("DB Mobile UPDATE ERROR\n" + e);
		}
		return -1;
		
	}
	public boolean removeCart(int cartId) {
	    query = "DELETE FROM cart WHERE cartId = ?";
	    try {
	        pstmt = Db.getPs(query);
	        pstmt.setInt(1, cartId);
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        System.out.println("DB Mobile DELETE ERROR\n" + e);
	    }
	    return false;
	}
	public List<Cart> getAllCartItems(int userId)
	{
		List<Cart> listOfCartItems = new ArrayList<>();
		query = "SELECT * FROM cart where userId = ?";
		try {
			pstmt = Db.getPs(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				listOfCartItems.add( new Cart(
						rs.getInt("cartId"),
						rs.getInt("mobileId"),
						rs.getInt("userId")
						));				
			}
			return listOfCartItems;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
