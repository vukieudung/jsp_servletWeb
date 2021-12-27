package model;

//Chua thong tin ve 1 san pham trong web
public class Product { 
	private int id;
	private String name;
	private String desciption;
	private float price;
	private String src;   
	private String type;
	private String brand;
	private int number;  //so luong san pham
	
	//Ham khoi tao
	public Product(int id, String name, String desciption, float price, String src, String type, String brand) {
		this.id = id;
		this.name = name;
		this.desciption = desciption;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
		this.number=0;
	}
	
	//Ham getter va setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	

	
	
}
