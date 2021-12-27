<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!--HEADER- ----------------------->

<c:import url="header.jsp">
<c:param name="title" value="LOG IN"></c:param>
</c:import>

<!--ARTICLE------------------------> 

<head>   
     <style>
     	<c:import url="css/login.css"></c:import>
     </style>
</head>
<div class="login_register">
    <c:set var="user" value="${suser}" /> 
    <c:set var="error" value="${error}" /> 
    <form action="${pageContext.request.contextPath}/LoginController" method="POST">
        <input type="hidden" name="action" value="dologin" />  <!-- submit form thi servlet se nhan duoc action nay -->
        <h2 >ĐĂNG NHẬP</h2>
                
        <p>Email hoặc Username:</p> 
        <input type="text" name="username" value="${user.getUsername()}" size="30" required><br><br>  <!-- bien value de luu gia tri nhap-->
        
        <p>Mật khẩu:</p>
        <input type="text" name="password" value="${user.getPassword()}" size="30" required><br><br>

        <input type="checkbox" value="yes">Ghi Nhớ<br><br>
        
        <button type="submit">Đăng Nhập</button>  <br><br>


        <p>----------------OR----------------</p> <br>
        
        <p><a class="link-normal" href="#" target="_blank">Quên mật khẩu?</a></p>

    </form>
        <h2 class="error"> <c:out value="${error}" ></c:out> </h2>

</div> 
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>
