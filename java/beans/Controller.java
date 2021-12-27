package beans;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import database.ProductsDatabase;
import model.User;

//@WebServlet(urlPatterns= {"/controllor_panel"})
public class Controller extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		//Trang main la home.jsp, va moi chuyen huong trang thuc hien qua action
		try {
			String action=request.getParameter("action");
            /*
             * Ban đầu khi chuyển qua trang login thì dũ liệu là không có
             * Ta lưu trữ dữ liệu trên session là ""
             */
		    //tao doi tuong beans
			User user=new User("", "","","","");
	    	//luu du lieu bang Session
	    	HttpSession session=request.getSession();  //goi doi tuong session
	    	
	    	
		    if (action == null) {
		    	request.setAttribute("pdList",new ProductsDatabase().search(""));  //tra lai list tat ca san pham
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);		 
		    	
		    //chuyen qua trang dang nhap
		    } else if (action.equals("login")) {  

		    	session.setAttribute("suser", user);
		    	session.setAttribute("error", "");
		    	request.getRequestDispatcher("/login.jsp").forward(request, response);

		    }  else if (action.equals("register")) {  

		    	session.setAttribute("suser", user);
		    	session.setAttribute("error", "");
		    	request.getRequestDispatcher("/register.jsp").forward(request, response);

		    }else {
		        Map<String,String> actionMap=new HashMap<String, String>();

		        actionMap.put("cart", "/cart.jsp");
		        
		 		request.getRequestDispatcher(actionMap.get(action)).forward(request, response);
		    }
		}catch (Exception e) {
			out.println(e);
		}
		
	}
    

}
