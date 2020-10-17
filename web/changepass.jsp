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
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
       if(rs.next()){ %>
        <script>
          function chk()
          {
              if(document.getElementById("old").value==<%=rs.getString(3)%>)
              {
                  return true;
              }
              else {
                  var e=document.getElementById("wrong");
                  e.style.display="block"; 
                 document.getElementById("wrong").innerHTML="Incorrect Old Password"; 
                  return false;
              }
              
          }function len()
            {
               var e=document.getElementById("wrong");
               e.style.display="none"; 
            }
            </script>
            <%  }  %>
    </head>
<body background="photos/190945.png">
      
   <% 
rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){%>
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px; height: 350px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px">
         <form action="cng_pass" method="post" onsubmit="return chk();">
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your old Password:</p><input  class="cng-email" type="password" placeholder="Old Password" required="required"id="old" oninput="len()">
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your New Password:</p><input  class="cng-email" type="text" placeholder="New Password" required="required" name="pass"><br><br>
             
             <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;" >Change Password</button><br>
             <p id="wrong" style="color:red;font-size: 15px; display: none;"></p>
         </form>
            </div>
    </center>
    
   
    </body>
    <% } %>
</html>
