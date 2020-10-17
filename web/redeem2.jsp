<%@page import="battlesround.dao"%>
<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
           <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
        <%
         Connection con=dao.getConnection();
       Statement stmt=con.createStatement();
       String email=(String)session.getAttribute("email");

       %>
    </head>
<body background="photos/190945.png">
      
   <% 
ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){%>
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px">
         <a>
             Choose Type
         </a>
         <form action="redeem3.jsp" method="post">
             <input type="hidden" value="<%=request.getParameter("amt")%>" name="amount"> 
             <table>
                 <tr>
                     <td> <input type="radio" checked="checked" name="amt" value="paytm" style="height: 18px;width: 18px;"></td>
                     <td> <img src="photos/paytm.jpg" height="55px" width="170px"></td>
             </tr>
          
             <tr>
                 <td>
                     <br><br>
             <input type="radio" name="amt" value="bank" style="height: 18px;width: 18px;">
                 </td>
                 <td style="font-size:23px"><br><i class="fa fa-money" aria-hidden="true"></i> Bank Transfer</td>
             </tr>
             </table><br>
             <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;">Continue</button><br>
         </form>
            </div>
    </center>
    
   
    </body>
    <% } %>
</html>
