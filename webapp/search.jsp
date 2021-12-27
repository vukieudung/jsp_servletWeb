<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--HEADER- ----------------------->

<c:import url="header.jsp">
<c:param name="title" value="SEARCH"></c:param>
</c:import>

<style>
<c:import url="css/search.css"></c:import>
</style>
<!--ARTICLE------------------------> 

<div class="content">
        <c:set var="list" value="${results}" />
 
		<table>
			<caption>
							        
                   <c:if test="${empty list}"> Không tìm thấy sản phẩm!!!</c:if>
				   <c:if test="${!empty list}">Tìm thấy sản phẩm!!!</c:if>
		  		
            </caption>
		    <c:set var="tablewidth" value="3" />		    
			<c:forEach var="i" items="${list}" varStatus="row"> 
				   <c:if test="${row.index % tablewidth ==0 }">   <%--lap duoc 3 vong thi no se xuong dong --%> 
				   		<tr> 
				   </c:if>
				    
					   <td>
					        <h4><c:out value="${i.getName()}"></c:out> </h4>
					        <p>
						        <a href="<c:url value="/InformationProductController?action=image&imgid=${i.getId()}"/>">
						   		<img src="${i.getSrc()}" />
						        </a>
					        </p>
					        
					       <p>Giá bán : $<c:out value="${i.getPrice()}"></c:out></p>
					   </td>
				   
				   <c:if test="${row.index +1  % tablewidth ==0}">
				      <c:out value="</tr>" /> 
				   </c:if> 
				      
				   
			</c:forEach>
	 </table>
	 
</div>
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>