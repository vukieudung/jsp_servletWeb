package model;

import java.util.ArrayList;

public class Cart { //chua thong tin ve gio hang
	private ArrayList<Product> items;  //List cua cac san pham trong cart
	
	//Ham khoi tao cho Cart
	public Cart() {
		this.items = new ArrayList<Product>();
	}
	
	//Tao ham getter
	public ArrayList<Product> getItems() {
		return this.items;
	}



	//them san pham moi vao cart
	public void addToCart(Product p) {
		
		for(Product x:this.items) {  
			if(p.getId() == x.getId()) { //neu san pham them vao cung loai sp da co trong gio hang
				x.setNumber(x.getNumber() +1);
				return;
			}
		}
		
		//neu khong thi them p vao cart
		this.items.add(p); 
		Product last=this.items.get(this.items.size()-1);
		last.setNumber(last.getNumber()+1);
	}
	
	
	//Xoa san pham co id truyen vao khoi cart
	public void removeFromCart(int id) {
		for(Product x:this.items) {
			if(x.getId() ==id) {
				this.items.remove(x);
				return;
			}
		}
	}
	
	//Xoa tat ca san pham khoi cart
	public void removeAllFromCart() {
           this.items.removeAll(items);
		
	}
	
	//Lay tong gia thanh trong cart
	public double getAmount() {
		double s=0;
		for (Product x:items) {
			s+=x.getPrice()*x.getNumber();
		}
		return s;
	
	}
	

}
