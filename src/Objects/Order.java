package Objects;

public class Order {
	private int orderId;
	private int mobileId;
	private int count;
	
	public Order(int orderId, int mobileId, int count) {
		this.orderId = orderId;
		this.mobileId = mobileId;
		this.count = count;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", mobileId=" + mobileId + ", count=" + count + "]";
	}
	
	
}
