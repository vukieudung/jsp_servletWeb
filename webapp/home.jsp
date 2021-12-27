<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!--HEADER- ----------------------->

<c:import url="header.jsp">
<c:param name="title" value="PHONEWEB"></c:param>
</c:import>

<!--ARTICLE------------------------> 
 <div class="article">     
    <div class="container-fluid foot">
           <div class="row"> 
               
                   <div class="col-xs-12 col-sm-3 col-md-3 col1">
                       <div class="phoneList">
                            <h3>Danh mục</h3><br>
                            <ul>
                                <li><a href="/PRJ321x_A3/SearchController?action=dosearch&searching=iphone">Apple</a></li>
                                <li><a href="/PRJ321x_A3/SearchController?action=dosearch&searching=samsung">Samsung</a></li>
                                <li><a href="/PRJ321x_A3/SearchController?action=dosearch&searching=sony">Sony</a></li>
                                <li><a href="/PRJ321x_A3/SearchController?action=dosearch&searching=huawei">Huawei</a></li> 
                           </ul>
                       </div>
                        
                       <div class="favorite">
                         <h3>Sản phẩm được yêu thích</h3><br>
 
                         <img src="img/iphone.png" alt="product1"/><br>
                         <img src="img/iphone.png" alt="product1"/><br>
                         <img src="img/iphone.png" alt="product1"/><br>
                         <img src="img/iphone.png" alt="product1"/>
                       </div>


                 </div>
                   <!--Products-----------------------> 
                   
                 
                 <div class="col-xs-12 col-sm-9 col-md-9 col2">
                 			<c:set var="list" value="${pdList}" />                 			            			
 	                         <div class="container-fluid tab">
 	                         
                                 <div class="row">
                                          <c:forEach var="i" items="${list}" varStatus="row"> 
				   								<c:if test="${row.index % 2 ==0 }">    
				   		              					<div class="col-xs-12 col-sm-6 col-md-6 col11">
                                               				<div class="product1" >
                                                   					<h3><c:out value="${i.getName()}"></c:out></h3><br>
                                                    				<a href="<c:url value="/InformationProductController?action=image&imgid=${i.getId()}"/>">
						   												<img src="${i.getSrc()}" />
						        									</a>
                                                  					 <p>Giá bán : $<c:out value="${i.getPrice()}"></c:out></p>
                                               				 </div>
                                       				  </div> 
				   		
				   		
				   								</c:if>
				    
												<c:if test="${row.index % 2 !=0 }">    
				   		            					<div class="col-xs-12 col-sm-6 col-md-6 col22">
                                                			<div class="product2" >
                                                   					<h3><c:out value="${i.getName()}"></c:out></h3><br>
                                                    				<a href="<c:url value="/InformationProductController?action=image&imgid=${i.getId()}"/>">
						   												<img src="${i.getSrc()}" />
						        									</a>
                                                   					<p>Giá bán : $<c:out value="${i.getPrice()}"></c:out></p>
                                                			</div>
                                      				 </div> 
				   		
				   		
				   							</c:if>
				   
										</c:forEach>
                                </div>
                          </div>                

                 </div>
                  <!--Products-----------------------> 

         </div>
     </div>
       		
 </div>
 <!--FOOTER----------------------->
 <c:import url="footer.jsp"></c:import>

