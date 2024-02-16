package Model;

import java.time.LocalDate;

public class Bill {
	private int billId;
	private LocalDate date;
	private int userId;
	private String purchaseType;
	private int orderId;
	private double totalAmount;
	
	public Bill(int billId, LocalDate date, int userId, String purchaseType, int orderId, double totalAmount) {
		this.billId = billId;
		this.date = date;
		this.userId = userId;
		this.purchaseType = purchaseType;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
	}
	public Bill( int userId, String purchaseType, int orderId, double totalAmount) {
		this.userId = userId;
		this.purchaseType = purchaseType;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", date=" + date + ", userId=" + userId + ", purchaseType=" + purchaseType
				+ ", orderId=" + orderId + ", totalAmount=" + totalAmount + "]";
	}
	
}
