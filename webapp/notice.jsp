<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--HEADER- ----------------------->

<c:import url="header.jsp">
<c:param name="title" value="NOTICE"></c:param>
</c:import>

<style>
	<c:import url="css/notice.css"></c:import>
</style>
<!--ARTICLE------------------------> 

<div class="content">
	<c:set var="n" value="${notice}" />
	<h3><c:out value="${n}" /></h3>
</div>
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>