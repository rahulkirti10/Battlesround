<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
    </head>
<body background="photos/190945.png">
         <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
   <% 
Connection con=dao.getConnection();
       Statement stmt=con.createStatement();
       String email=(String)session.getAttribute("email");
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){%>
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px"><br>
         <form action="cng_email" method="post">
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your New Email:</p><input  class="cng-email" type="email" placeholder="Email" name="email2" required="required"><br><br><br>
            
            <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;" >Change Email</button><br><br>
         </form>
            </div>
    </center>
    
   
    </body>
    <% } %>
</html>
