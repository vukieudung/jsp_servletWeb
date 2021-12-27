<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!--HEADER- ----------------------->

<c:import url="header.jsp">
<c:param name="title" value="REGISTER"></c:param>
</c:import>

<!--ARTICLE------------------------> 


<head>   
     <style>
     	<c:import url="css/login.css"></c:import>
     </style>
</head>

<div class="login_register">

    <c:set var="error" value="${error}" /> 
    <form action="${pageContext.request.contextPath}/RegisterController" method="POST">
        <input type="hidden" name="action" value="doregister" />  <!-- submit form thi servlet se nhan duoc action nay -->
        <h2 >ĐĂNG KÝ </h2>
                
        <p>Email hoặc Username:</p>
        <input type="text" name="username" size="30" required><br><br>  <!-- bien value de luu gia tri nhap-->
        
        <p>Mật khẩu:</p>
        <input type="text" name="password"  size="30" required><br><br>

        <p>Họ và tên:</p>
        <input type="text" name="fullname"  size="30" required><br><br>
        
         <p>Địa chỉ:</p>
        <input type="text" name="address"  size="30" required><br><br>
        
        <p>Số điện thoại:</p>
        <input type="text" name="phone"  size="30" required><br><br>

        
        <button type="submit">Đăng Ký</button>  <br><br>


        <p>----------------OR----------------</p> <br>

    </form>
        <h2 class="error"> <c:out value="${error}" ></c:out> </h2>

</div> 
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>
