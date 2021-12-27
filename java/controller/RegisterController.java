package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.JDBCConnect;
import model.User;
import model.UserDatabase;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		JDBCConnect JDBC=new JDBCConnect();
		Connection conn;
		//Trang main la home.jsp, va moi chuyen huong trang thuc hien qua action
		try {	
			conn = JDBC.getConnection();
			String action=request.getParameter("action");
		    
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);
		    			    	
		    }  else if (action.equals("doregister")) {
		    	String userName =request.getParameter("username");
		    	String passWord =request.getParameter("password");
		    	String fullName =request.getParameter("fullname");
		    	String address =request.getParameter("address");
		    	String phone =request.getParameter("phone");
		    	
		    	
			    //tao doi tuong beans
		    	User user=new User(userName, passWord,fullName,address,phone);		    
		    	UserDatabase acc= new UserDatabase(conn);  //ket noi voi database
		    	
		    	//luu du lieu bang Session
		    	HttpSession session=request.getSession();  //goi doi tuong session		    	
		    	session.setAttribute("suser", user);
		    	
		    	if(user.validate()) {  //xac thuc tinh dung dan cua username va password
		    		if(!acc.accAready(userName)) { //neu tai khoan chua co
		    			acc.create(userName, passWord,fullName,address,phone);		    			
			    		session.setAttribute("notice", "Đăng ký thành công!!!");
			    		request.getRequestDispatcher("/notice.jsp").forward(request, response);
		    		} else {
	                    session.setAttribute("error", "Mail/Username đã tồn tại!!!");
				    	request.getRequestDispatcher("/register.jsp").forward(request, response);
		    		}	    		

		    	} else {
                    session.setAttribute("error", user.getMessage());
			    	request.getRequestDispatcher("/register.jsp").forward(request, response);

		    	}
		    }
		}catch (Exception e) {
			out.println(e);
		}
		
    }

}
