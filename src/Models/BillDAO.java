package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Objects.Bill;

public class BillDAO {
	PreparedStatement pstmt;
	String query;
	
	public int addBill(Bill billObject) {
        query = "INSERT INTO bill(userId, purchasetype, totalAmount) VALUES (?, ?, ?)";
        try {
            pstmt = Db.getPs(query, true);
            pstmt.setInt(1, billObject.getUserId());
            pstmt.setString(2, billObject.getPurchaseType());
            pstmt.setDouble(3, billObject.getTotalAmount());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    int billId = generatedKeys.getInt(1);
                    return billId;
                }
            }
        } catch (SQLException e) {
            System.out.println("BillController--addBill\n" + e);
        }

        return -1;
    }
	public int getBillCount() {
		query = "SELECT count(billId)as count FROM bill";
		try {
			pstmt = Db.getPs(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{	
				return rs.getInt("count")+1;
			
			}
		} catch (SQLException e) {
			System.out.println("BillController--getBillByBillId\n" + e);
		}
		return 0;
		
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
	                    rs.getDouble("totalAmount")
    					);
    		}
    	} catch (SQLException e) {
    		System.out.println("BillController--getBillByBillId\n" + e);
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
    					rs.getDouble("totalAmount")
    					));
    		}
    		return listOfBill;
    	} catch (SQLException e) {
    		System.out.println("BillController--getBillByUserId\n" + e);
    	}
    	return null;
    	
    }
}
