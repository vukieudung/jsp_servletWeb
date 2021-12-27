package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {
	private final String dbName ="ShoppingDB";
	private final String user ="sa";
	private final String password ="fumiya87";
	
	public Connection getConnection() throws Exception {
		Connection conn=null;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //dang ky driver SQL SERVER
		String url="jdbc:sqlserver://localhost:1433;databaseName="+dbName;
		conn=DriverManager.getConnection(url,user,password);  //ket noi voi database
		//conn.close();
		return conn;
							
	}
		   

}
