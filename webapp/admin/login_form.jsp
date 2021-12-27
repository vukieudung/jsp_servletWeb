
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Management</title> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!---use Vietnamese font--->
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
  <!---use Boostrap--->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!----------------->
 
   <style><%@ include file="../css/login_form.css" %></style>
 
  
</head>
<!-------------------------------HTML------------------------------------>
<body>

<!--use Boostrap- -----------------------> 
 <div class="article">     
    <div class="container-fluid">
            <!--row-----------------------> 
            <div class="row">               
                      <div class="col-xs-2 col-sm-2 col-md-2 col1">
                          <div >
                             <h3> 88 Team</h3>                            
                          </div>
                          <div>
                             <p><a href="#">Dashboard</a></p>
                             <p><a href="#">Staff Manager</a></p>
                          </div>
                      </div>

                      <div class="col-xs-10 col-sm-10 col-md-10 col2">
                          <div>
                               <img src="/PRJ321x_A1/img/banner.jpg" alt="banner"/>
                          </div>
                          <div class="content">
                          
                             <table>
                                    <caption>Members of team</caption>
                                    <tr>
                                      <th>ID</th>
                                      <th>Name</th>
                                     
                                    </tr>
                                    
                                    <tr>
                                      <td>1</td>
                                      <td>Member1</td>
                                    </tr>
                                    
                                    <tr>
                                      <td>2</td>
                                      <td>Member2</td>
                                    </tr>
                            </table>
                          </div>


                     </div>
          </div>  

   </div>
</div>

</body>
<!------------------------------------------------------------------->
</html>
