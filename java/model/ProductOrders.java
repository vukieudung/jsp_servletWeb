package model;

//Thong tin cua 1 san pham trong don hang
public class ProductOrders {
	private int orderId;
	private int productId;
	private String productName; 
	private int productAmount;  //so luong san pham trong don hang
	
	//Ham khoi tao
	public ProductOrders(int orderId, int productId, String productName, int productAmount) {
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
	}

	//Ham getter va setter
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
	
	

}
