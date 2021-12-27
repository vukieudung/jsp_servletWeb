package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.OrdersDatabase;
import model.Cart;
import model.Orders;

import model.User;


/**
 * Luu thong tin don hang va khach hang vao datasource
 */
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			String action=request.getParameter("action");
			
		    if (action == null) {
		    	request.getRequestDispatcher("/home.jsp").forward(request, response);		    			    	
		    } else if (action.equals("pay")) {  //Khi mua hang se thuc hien lua thong tin don hang vao database
		    	
		    	HttpSession session=request.getSession();  //goi doi tuong session

		    	OrdersDatabase odb= new OrdersDatabase();
		    	Cart c=(Cart) session.getAttribute("cart"); //lay thong tin cart luu tren session

		    	if ( c==null || c.getAmount()==0) {	//Neu trong gio hang khong co thi se khong mua duoc
		    		session.setAttribute("notice", "Không có sản phẩm trong giỏ hàng !!!");
		    		request.getRequestDispatcher("/notice.jsp").forward(request, response);
		    		return;
		    	} 	    	
		    	User u=(User) session.getAttribute("successUser");  //lay thon tin nguoi dang nhap luu tren session

		    	//tao ra mot don dat hang
		    	Orders o=new Orders(u,c);
		    	odb.insertOrder(o)	;	//update thong tin cart vao database
		    	
		    	//Xoa thong tin gio hang
		    	c.removeAllFromCart();

		    	//Sau khi luu thong tin vao database se hien thong bao thanh cong
		    	session.setAttribute("notice", "Mua hàng thành công !!!");
		    	request.getRequestDispatcher("/notice.jsp").forward(request, response);
		    } 
		    
		}catch (Exception e) {
			out.println(e);
		}
	}



}
