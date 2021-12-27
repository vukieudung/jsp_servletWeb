<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--HEADER- ----------------------->
<c:import url="header.jsp">
<c:param name="title" value="INFO OF PRODUCT"></c:param>
</c:import>

<style>
 <c:import url="css/infoProduct.css"></c:import>
</style>

<div class="infoProduct">
                
	<%--ket qua product lay duoc duoc gan cho bien pd--%> 
	<c:set var="pd" value="${product}" />  
				
				<table>
					  <caption>  ${pd.getName()}  </caption>

					  <tr>
						    <td class="col1"><img src="${pd.getSrc()}" /></td>
						    <td class="col2">
						    		<h4 class="price">Giá bán: $<c:out value="${pd.getPrice()}"/></h4>
						    		<h4>Thông tin chi tiết:</h4>
						    		<p>$<c:out value="${pd.getDesciption()}"/></p>
						    		
						    		<form action="${pageContext.request.contextPath}/AddToCartController" method="GET">
						    			<input type="hidden" name="action" value="doAddCart" />						    			
						    			<input type="hidden" name="productId" value="${pd.getId()}" />
						    			
						    			<button type="submit">Thêm vào giỏ hàng</button>
						    		
						    		</form>
   
						    </td>
						    
	
					  </tr> 
			   </table>
 
</div>
		  
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>