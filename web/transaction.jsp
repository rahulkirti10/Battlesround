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
       ResultSet rs=stmt.executeQuery("select * from coins_payment where email='"+email+"' order by c_id desc"); 
%>
<br><br><br><br><br>
  <center>
    <table width='100%'  style='color:white;font-size:30px;font-family: sans-serif;'>
        <tr>
            <th># Cust_Id</th>
            <th>Order_Id</th>
            <th>Email</th>
            <th>Amount</th>
            <th>Transaction</th>
        </tr>
          <%    while(rs.next())
        {
            %>
        <tr>
            <td><center># <%=rs.getString(2)%></center></td>   
            <td><center><%=rs.getString(6)%></center></td>   
            <td><center><%=rs.getString(3)%></center></td> 
            
            <td><center><%=rs.getString(4)%></center></td>
            <td><center><%=rs.getString(5)%></center></td> 
        </tr>
        <% } %>
    </table>  
    </center>
       </body>
</html>
