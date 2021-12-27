<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--HEADER- ----------------------->
<c:import url="header.jsp">
<c:param name="title" value="CART"></c:param>
</c:import>

 <style>
  <c:import url="css/cart.css"></c:import>
 </style>

<!--ARTICLE------------------------> 

<div class="content">
     <c:set var="cartItems" value="${cart.items}" />
      
        <table>
        	<caption>Giỏ hàng</caption>
        	<tr>
        		<th>Sản phẩm</th>
        		<th>Giá bán ($)</th>
        		<th>Số lượng</th>
        		<th>Thành tiền ($)</th>
        		<th>Chỉnh sửa</th>
        	
        	</tr>
        	
	       	<c:forEach var="i" items="${cartItems}"> 
						
				<tr>
					<td><c:out value="${i.getName()}"></c:out> <br/>
					    Mã : <c:out value="${i.getId()}"></c:out> 					
					</td>
				    <td><c:out value="${i.getPrice()}"></c:out> </td>
				    <td><c:out value="${i.getNumber()}"></c:out> </td>
				    <td><fmt:formatNumber value="${i.getPrice()*i.getNumber()}"  maxFractionDigits="2" /></td>
				    
				    <td>
				    	<form action="${pageContext.request.contextPath}/AddToCartController" method="GET">
						    			<input type="hidden" name="action" value="removeFromCart" />						    			
						    			<input type="hidden" name="productId" value="${i.getId()}" />						    			
						    			<button type="submit">Xóa</button>						    		
						</form>
				    
				    </td>
				    
				
				</tr>			   
							

		    </c:forEach>
		    
		    <tr>
                <c:set var="c" value="${cart}" />
        		<td  class="last_row" colspan="4">Tổng tiền : <fmt:formatNumber value="${c.getAmount()}"  maxFractionDigits="2" /> ($) </td>
        	
        	</tr>
		</table>
		
		<div class="payOrder">
		  	<form action="${pageContext.request.contextPath}/PayController" method="GET">
						    			<input type="hidden" name="action" value="pay" />						    			
						    			<input type="hidden" name="c" value="${cart}" />						    			
						    			<button type="submit">Mua hàng</button>						    		
			</form>
		
		</div>
	 
</div>
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>

