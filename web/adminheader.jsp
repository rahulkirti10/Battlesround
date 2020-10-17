<%@page import="java.sql.*"%>
<%@page import="battlesround.dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" media="mediatype and|not|only (expressions)" href="print.css"> 
        <link rel = "icon" href =  "photos/titlelogo.png" type = "image/x-icon"> 
           <title>battlesround</title> 
    </head>
    <script>
       
        function show()
        {
     if(document.getElementById("nav").style.display=="block")
     document.getElementById("nav").style.display="none";
 else
     document.getElementById("nav").style.display="block";
    }
      
        </script>
        <body>
  <img style="position:absolute;top:0; left:0;" class="logo" src="photos/titlelogo.png" height="50px" width="50px">  
        <div class="nav" id="nav">
            <center>
      <ul>
        
    <li>
        <a href="adminpannel.jsp" ><i class="fa fa-home" aria-hidden="true"></i> HOME</a>    <br><br>
    </li>
    <li>
        <a href="adminbattles.jsp" ><i class="fa fa-shield" aria-hidden="true"></i> BATTLES</a><br><br>
    </li>  
    <li>
        <a href="viewuser.jsp" ><i class="fa fa-bar-chart" aria-hidden="true"></i>Users</a><br><br>
    </li> 
    <li>
        <a href="payment.jsp" >Payment</a><br><br>
    </li> 
    <li>
        <a href="admin.jsp" >Admin</a><br><br>
    </li> 
       <%
Connection con=dao.getConnection();
       Statement stmt=con.createStatement();
       String email=(String)session.getAttribute("email");
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){
 %>
<li>
    <a href="profile.jsp" class="profile-name"><%=rs.getString(4)%></a><br><br>
    </li>
    
    <li>
        <a href="logout" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i> Logout</a><br><br>
    </li> 
    <% } %>
      </ul>
            </center>
  </div>
  <div>
      <ul>
      <li>
      <a id="slider" class="slider" onclick="show()" href="#"><i class="fa fa-bars" style="color:white;" aria-hidden="true"></i></a>
    </li>
        </ul>   
  </div>
 

    </body>
</html>