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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		JDBCConnect JDBC=new JDBCConnect();
		Connection conn;
	
		try {	
			conn = JDBC.getConnection();
			String action=request.getParameter("action");
		    
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);
		    			    	
		    } else if (action.equals("dologin")) {
		    	String username =request.getParameter("username");
		    	String password =request.getParameter("password");
		    	
			    //tao doi tuong beans
		    	User user=new User(username, password);
		    	UserDatabase acc= new UserDatabase(conn);
			    		    	
		    	//luu du lieu bang Session
		    	HttpSession session=request.getSession();  //goi doi tuong session		    	
		    	session.setAttribute("suser", user);
		    	if(user.validate()) {  //xac thuc tinh dung dan cua username va password
		    		
		    	    if (acc.login(username, password)) {
		    	    	session.setAttribute("successUser", user);
			    		session.setAttribute("notice", "Đăng nhập thành công!!!");
			    		request.getRequestDispatcher("/notice.jsp").forward(request, response);
		    		} else {		    			
		    			session.setAttribute("error", "Email/Username hoặc mật khẩu là không chính xác");
		    			request.getRequestDispatcher("/login.jsp").forward(request, response);
		    		}
		    				    		

		    	} else {
                    session.setAttribute("error", user.getMessage());
			    	request.getRequestDispatcher("/login.jsp").forward(request, response);

		    	}
		    			    
		    	
		    }
		}catch (Exception e) {
			out.println(e);
		}
	}

}
