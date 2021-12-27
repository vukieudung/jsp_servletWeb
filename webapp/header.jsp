<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>${param.title}</title>
  <meta charset="utf-8">

  <meta name="description" content="WEB BAN HANG">
  <meta name="keywords" content="WEB BAN HANG">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!---use Vietnamese font--->
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
  <!---use Boostrap--->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!----include css--<link type="text/css" rel="stylesheet" href="css/header.css" />-----------> 
  
  <style>
  <c:import url="css/header.css"></c:import>
  </style>
</head>
<!-------------------------------HTML------------------------------------>
<body>
   <!-- Modal Searching--------------------------------->
    <div class="header">      
        <div class="pos" id="modal">
            
            <div class="modalSearching" >  
               <img src="${pageContext.request.contextPath}/img/logo.png" alt="logo"/>
               
               <form action="${pageContext.request.contextPath}/SearchController" method="GET" class="form1">
               		 <input type="hidden" name="action" value="dosearch" />  <!-- submit form thi servlet se nhan duoc action nay -->
	                 <input type="text" id="keyword" name="searching" required/>
	                 <input type="submit" id="submit" value="Tìm kiếm" />
               </form> 

            </div>
        </div>
    </div> 
    
     <!--menu--------------------------------->    
    <div class="nav">
          
           <div class="dropdown">
                <p class="dropbtn">&#128220;</p>
                <div class="dropdown-content">
                    <a href="${pageContext.request.contextPath}/Controller">Trang chủ</a>
                    <a href="${pageContext.request.contextPath}/ProductListController?action=productList">Sản phẩm</a>
                    <a href="#">Khuyến mãi</a>
                </div>
		   </div>
                 
           <ul class="left">
        	<li><a href="${pageContext.request.contextPath}/Controller">Trang chủ</a></li>
        	<li><a href="${pageContext.request.contextPath}/ProductListController?action=productList" >Sản phẩm</a></li>
            <li><a href="#">Khuyến mãi</a></li>       
          </ul>
          
          <ul class="right">
        	<li><a href="${pageContext.request.contextPath}/Controller?action=cart" >Giỏ hàng</a></li>
        	<li><a href="${pageContext.request.contextPath}/Controller?action=register" >Đăng ký</a></li>
        	
        	<c:set var="user" value="${successUser}" />
        	<c:if test="${empty user}">
            	<li><a href="${pageContext.request.contextPath}/Controller?action=login" >Đăng nhập</a></li>      
            </c:if> 
            
            <c:if test="${!empty user}">
            	<li><a href="${pageContext.request.contextPath}/Controller" >Đăng xuất</a></li>      
            </c:if> 
          </ul>
           
    </div>
