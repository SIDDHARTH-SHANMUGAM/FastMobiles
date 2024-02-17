package Objects;

public class Cart {
	private int cartId;
	private int mobileId;
	private int userId;
	public Cart(int cartId, int mobileId, int userId) {
		this.cartId = cartId;
		this.mobileId = mobileId;
		this.userId = userId;
	}
	public Cart( int mobileId, int userId) {
		this.mobileId = mobileId;
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", mobileId=" + mobileId + ", userId=" + userId + "]";
	}
}
