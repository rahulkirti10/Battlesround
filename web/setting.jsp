<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
        <script> 
        function showd()
            {
                var e=document.getElementById("cancel");
                e.style.display="block";
            }
            function noshow()
            {
                var e=document.getElementById("cancel");
                e.style.display="none";
            }
           </script>
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
            <button class="profilepart" onclick="location.href='changeemail.jsp'"><i class="fa fa-envelope" style="font-size: 30px;"></i> Change Email</button><br><br>      
            <button class="profilepart" onclick="location.href='changepass.jsp'"><i class="fa fa-unlock-alt" aria-hidden="true" style="font-size: 30px;"></i> Change Password</button><br><br>
            <button class="profilepart"  onclick="location.href='changename.jsp'"><i class="fa fa-user" aria-hidden="true" style="font-size: 30px;"></i> Change Name</button><br><br>
            <button class="profilepart"  onclick="showd() "><i class="fa fa-user" aria-hidden="true" style="font-size: 30px;"></i> Delete Account</button><br><br>
    </div>
    </center>
    <div class="cancel" id="cancel">
        <br>
        <center> <p> <i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Are you Sure You Want to Delete Your Account.</p>  
            <br><br>
            <form action='deleteaccount' method='post'>   
                <input type="button" onclick="noshow()" value="Cancel" class="cancel-button">
            <input type="submit" value="Yes"  class="cancel-button">
            </form>             
        </center>
    </div>
   
    </body>
    <% } %>
</html>
