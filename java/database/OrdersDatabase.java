package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.JDBCConnect;
import model.Orders;
import model.Product;

//cac phuong thuc lam viec voi bang Orders
public class OrdersDatabase {
	JDBCConnect JDBC=new JDBCConnect();
	//them thong tin cua Order toi database: san pham trong cart va thong tin nguoi mua trong Orders
	
	
	public void insertOrder(Orders o) throws Exception {
	
		Connection conn=JDBC.getConnection();
		
		//thuc hien truy van trong bang Orders, them thong tin cua nguoi mua vao Orders	---------------------------------	
    	String sql1="SELECT TOP(1) order_id FROM Orders ORDER BY order_id DESC";
    	PreparedStatement st1=conn.prepareStatement(sql1);  //Thuc hien truy van trong csdl
    	ResultSet result=st1.executeQuery();  //Tra lai ket qua truy van
    	
    	int orderId=0;
    	while (result.next()) {
    		orderId=result.getInt("order_id");
    	}
		
    	String sql2="INSERT INTO Orders Values (?,?)";
    	PreparedStatement st2=conn.prepareStatement(sql2);  //Thuc hien truy van trong csdl
    	
    	String username=o.getUser().getUsername();
    	orderId=orderId+1;
    	st2.setString(1, username);
    	st2.setInt(2, orderId);   
    	st2.executeUpdate(); //update truy van
    	

    	
    	//Them thong tin vao bang Orders_detail-------------------------------------------------------------------------
    	String sql3="INSERT INTO Orders_detail Values (?,?,?,?)";
    	PreparedStatement st3=conn.prepareStatement(sql3);  //Thuc hien truy van trong csdl
    	
    	ArrayList<Product> itemsList =o.getCart().getItems();
    	for(int i=0 ; i<itemsList.size();i++) {
        	st3.setInt(1, orderId);
        	st3.setInt(2, itemsList.get(i).getId());
        	st3.setInt(3, itemsList.get(i).getNumber());
        	st3.setFloat(4, itemsList.get(i).getPrice());
        	st3.executeUpdate(); //update truy van
    		
    	}

    	st1.close();
    	st2.close();
    	st3.close();
	}
}
