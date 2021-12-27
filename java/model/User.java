package model;

public class User {
	private String username;
	private String password;
	private String fullName;
	private String address;
	private String phone;
	private String message;
	
	//Ham khoi tao
	public User(String username, String password, String fullName, String address, String phone) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}
   
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//Ham getter va setter
	public String getUsername() {
		return username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return this.message;
	}

	
    //Kiem tra viec nhap du lieu
	public boolean validate() {
		if(this.password.length() <8) {
			this.message="Mật khẩu phải có ít nhất 8 ký tự!";
		    return false;
		}
		
		return true;
	}
	

}
