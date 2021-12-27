package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ProductsDatabase;

/**
 * Dieu khien chuc nang xem thong tin chi tiet cua mot san pham
 */
public class InformationProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();

		try {
			String action=request.getParameter("action");		    
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);		 
		    	
		    //chuyen qua trang thuc hien show thong tin cua san pham theo id

		    } else if (action.equals("image")) {  		    	
		    	String id=request.getParameter("imgid");  //lay gia tri tham so imgid	    	
		    	request.setAttribute("product",new ProductsDatabase().getProduct(id));  //thong tin san pham tu database duoc luu vao bien product		    	
		    	request.getRequestDispatcher("/infoProduct.jsp").forward(request, response);

		    } 
		}catch (Exception e) {
			out.println(e);
		}
	}
	



}
