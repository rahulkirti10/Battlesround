<%@page import="java.sql.ResultSet"%>
<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script>
            function disp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="block";
               e=document.getElementById("profiletab");
               e.style.display="none";
                e=document.getElementById("profiledown");
               e.style.display="none";
  
  
            }
                        function ndisp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="none";
                e=document.getElementById("profiletab");
               e.style.display="block";
                e=document.getElementById("profiledown");
               e.style.display="block";
            }
            </script>
    </head>
  <body background="photos/190945.png">
         <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
   <% 
Connection con=dao.getConnection();
       Statement stmt=con.createStatement();
       Statement st=con.createStatement();
       String email=(String)session.getAttribute("email");
       ResultSet rs=stmt.executeQuery("select * from battle_registration where email='"+email+"'"); 
%>
<br><br><br><br><br>
  <center>
    <table width='100%'  style='color:white;font-size:30px;font-family: sans-serif;'>
        <tr>
            <th># Battle Id</th>
            <th><i class="fa fa-trophy" aria-hidden="true"></i> Winning</th>
            <th>Kills</th>
             <th><img class="coins" src="photos/coin.png" style='height:30px; width:30px;border-radius: 30px;'> Battle Fee</th>
        </tr>
          <%    while(rs.next())
        {
            %>
        <tr>
            <td><center># <%=rs.getString(3)%></center></td>   
            <td><center><%=rs.getString(6)%></center></td>   
            <td><center><%=rs.getString(5)%></center></td> 
            
            <td><center><%=rs.getString(7)%></center></td>   
        </tr>
        <% } %>
    </table>  
    </center>
       </body>
</html>
