package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProductsDatabase;
import model.Cart;
import model.Product;

/**
 * Control chuc nang them san pham vao gio hang
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			String action=request.getParameter("action");
			
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);		    			    	
		    } else if (action.equals("doAddCart")) {  //Khi add vao gio hang 
		    			    	
		    	HttpSession session=request.getSession();  //goi doi tuong session

		    	if(session.getAttribute("successUser") == null) {  //PHAI LOGIN MOI CO THE ADD TO CART
		    		request.getRequestDispatcher("/Controller?action=login").forward(request, response);
		    		return;
		    	} 
		    	
		    	if(session.getAttribute("cart")==null) {
		    		session.setAttribute("cart",new Cart());  // ta se luu doi tuong Cart vao bien cart tren session
		    	}
		    	
		    	String id=request.getParameter("productId");  //lay id cua product tu form
		    	Product p=new ProductsDatabase().getProduct(id); //Lay product theo id
		    	
		    	Cart c=(Cart) session.getAttribute("cart");
		    	c.addToCart(p); //Them san pham vao cart
		    	request.getRequestDispatcher("/cart.jsp").forward(request, response);

		    } else if (action.equals("removeFromCart")) {  //Khi add vao gio hang 
		    	
		    	HttpSession session=request.getSession();  //goi doi tuong session
		    	String id=request.getParameter("productId");  //lay id cua product tu form
		    	int id1=Integer.parseInt(id);
		    	Cart c=(Cart) session.getAttribute("cart");
		    	c.removeFromCart(id1); //Xoa san pham tu cart
		    	request.getRequestDispatcher("/cart.jsp").forward(request, response);
		    } 
		    
		}catch (Exception e) {
			out.println(e);
		}
	}



}
