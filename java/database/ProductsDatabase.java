package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.JDBCConnect;
import model.Product;

//cac phuong thuc lam viec voi database product table
public class ProductsDatabase {
	
	JDBCConnect JDBC=new JDBCConnect();



	//tra ve list cac san pham duoc tim kiem bang tu khoa keyWord-- chuc nang tim kiem cua nguoi dung
	public ArrayList<Product> search(String keyWord) throws Exception {
		Connection conn=JDBC.getConnection();
    	String sql="SELECT * FROM Products";
    	PreparedStatement st=conn.prepareStatement(sql);  //Thuc hien truy van trong csdl
    	ResultSet result=st.executeQuery();  //Tra lai ket qua truy van
    	
    	ArrayList<Product> list =new ArrayList<Product>();

    	
    	while (result.next()) {
    		String sqlName= result.getString("product_name").toLowerCase();
    		
    		if(sqlName.contains(keyWord.toLowerCase())) {
    		
    			int sqlID=result.getInt("product_id");
    			String sqlDes=result.getString("product_des");
    			float sqlPrice=result.getFloat("product_price");
    			String sqlImageSource=result.getString("product_img_source");
    			String sqlType=result.getString("product_type");
    			String sqlBrand=result.getString("product_brand");
    		
    			Product p= new Product(sqlID, sqlName, sqlDes, sqlPrice, sqlImageSource, sqlType, sqlBrand);
    			list.add(p);
    		
    		}
    	}
    	st.close();
    	return list;
	}


	
	//lay thong tin san pham product
	public Product getProduct(String id) throws Exception {
		Connection conn=JDBC.getConnection();
    	String sql="SELECT * FROM Products";   	
    	PreparedStatement st=conn.prepareStatement(sql);  //Thuc hien truy van trong csdl
    	ResultSet result=st.executeQuery();  //Tra lai ket qua truy van

    	while (result.next()) {
    		int sqlID=result.getInt("product_id");
    		if(sqlID==Integer.parseInt(id)) {
    		
    			String sqlName= result.getString("product_name");
    			String sqlDes=result.getString("product_des");
    			float sqlPrice=result.getFloat("product_price");
    			String sqlImageSource=result.getString("product_img_source");
    			String sqlType=result.getString("product_type");
    			String sqlBrand=result.getString("product_brand");
    		
    			Product p= new Product(sqlID, sqlName, sqlDes, sqlPrice, sqlImageSource, sqlType, sqlBrand);
    			return p;
    		}
    	}
    	
    	return null;
	}
}
