package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Model.Bill;

public class BillController {
	PreparedStatement pstmt;
	String query;
	
	public int addBill(Bill billObject) {
        query = "INSERT INTO bill(userId, purchasetype, orderId, totalAmount) VALUES (?, ?, ?, ?)";
        try {
            pstmt = Db.getPs(query, true);
            pstmt.setInt(1, billObject.getUserId());
            pstmt.setString(2, billObject.getPurchaseType());
            pstmt.setInt(3, billObject.getOrderId());
            pstmt.setDouble(4, billObject.getTotalAmount());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    int billId = generatedKeys.getInt(1);
                    return billId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB User INSERT ERROR\n" + e);
        }

        return -1;
    }

    public Bill getBillById(int billId)
    {
    	query = "SELECT * FROM bill WHERE billId = ? ";
    	try {
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, billId);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next())
    		{	return new Bill(
    					rs.getInt("billId"),
	                    rs.getDate("date").toLocalDate(),
	                    rs.getInt("userId"),
	                    rs.getString("purchaseType"),
	                    rs.getInt("orderId"),
	                    rs.getDouble("totalAmount")
    					);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
    public List<Bill> getBillByUserId(int userId)
    {
    	List<Bill> listOfBill = new ArrayList<>();
    	query = "SELECT * FROM bill WHERE userId = ? ";
    	try {
    		pstmt = Db.getPs(query);
    		pstmt.setInt(1, userId);
    		ResultSet rs = pstmt.executeQuery();
    		while(rs.next())
    		{
    			listOfBill.add( new Bill(
    					rs.getInt("billId"),
    					rs.getDate("date").toLocalDate(),
    					rs.getInt("userId"),
    					rs.getString("purchaseType"),
    					rs.getInt("orderId"),
    					rs.getDouble("totalAmount")
    					));
    		}
    		return listOfBill;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
}
