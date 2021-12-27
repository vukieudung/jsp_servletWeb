package model;

//Chua thong tin ve 1 don hang: danh sach san pham , thong tin nguoi mua
public class Orders {
	private User user;
	private Cart cart;
	

	//ham khoi tao
	public Orders(User user, Cart cart) {
		this.user = user;
		this.cart = cart;
	}


	//Ham getter va setter
		
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
}
