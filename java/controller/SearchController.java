package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ProductsDatabase;


/**
 * Chuc nang tim kiem danh cho nguoi dung
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		//Trang main la home.jsp, va moi chuyen huong trang thuc hien qua action
		try {
			String action=request.getParameter("action");
		    
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);		 
		    	
		    //chuyen qua trang thuc hien tim kiem
		    } else if (action.equals("dosearch")) {  
		    	
		    	String keyWord=request.getParameter("searching");  //tu khoa tim kiem
		    	
		    	request.setAttribute("results",new ProductsDatabase().search(keyWord));  //list cac product trung voi tu khoa se duoc luu va bien results
		    	
		    	request.getRequestDispatcher("/search.jsp").forward(request, response);

		    } 
		}catch (Exception e) {
			out.println(e);
		}
	}


}
