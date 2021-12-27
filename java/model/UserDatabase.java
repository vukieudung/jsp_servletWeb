package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase {
    private Connection conn;
    
    public UserDatabase(Connection conn) {
    	this.conn =conn;
    }
    
    //xac thuc xem tai khoan dang ky da co chua    
    public boolean accAready(String username)  throws SQLException {
    	String sql="SELECT * FROM Account";
    	PreparedStatement st=conn.prepareStatement(sql);  //Thuc hien truy van trong csdl   	
    	ResultSet rs=st.executeQuery();  //Tra lai ket qua truy van
    	

    	while (rs.next()) {
    		String sql_username= rs.getString("user_mail");
    		if(username.equals(sql_username)) {
    			return true;
    		}
    	}    	
    	return false;
    	
    }
    
    //them thong tin vao database khi dang ky tai khoan
    public void create(String username, String password, String fullname, String address, String phone) throws SQLException {
    	String sql="INSERT INTO Account Values (?,?,?,?,?)";
    	PreparedStatement st=conn.prepareStatement(sql);  //Thuc hien truy van trong csdl
    	
    	st.setString(1, username);
    	st.setString(2, password);
    	st.setString(3, fullname);
    	st.setString(4, address);
    	st.setString(5, phone);
    	
    	st.executeUpdate(); //update truy van
    	
    	st.close();
    }
   
    //Login vao tai khoan
    public boolean login(String username, String password) throws SQLException {
    	
    	String sql="SELECT * FROM Account";
    	PreparedStatement st=conn.prepareStatement(sql);  //Thuc hien truy van trong csdl
    	
    	ResultSet rs=st.executeQuery();  //Tra lai ket qua truy van
    	int count=0;
    	while (rs.next()) {
    		String sql_username= rs.getString("user_mail");
    		String sql_password= rs.getString("password");
    		if(username.equals(sql_username) && password.equals(sql_password)) {
    			count++;
    		}
    	}
    	
    	st.close();
    	if(count==0) {
    		return false;
    	} else {
    		return true;
    	}
    	
    	
    }
}
