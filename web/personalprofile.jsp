<%@include file="header.jsp"%>
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
Statement stm=con.createStatement();
       %>
    </head>
     <body background="photos/190945.png">
      
   <% 
ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
ResultSet rst=stm.executeQuery("select * from profile where email='"+email+"'");
if(rs.next()){
   if(rst.next())
   {
   %>
<br><br><br><br>
    <center>
        <div class="profiletab"  style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;"><br>
         <img src="<%=rs.getString(5)%>"  height="200px" class="profile-tab" width="200px">
         <form action="update_profile" method="post" onsubmit="return chk();">
             <a>Update Profile</a>
             <table >
                 <tr><td>
                 <center>
  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Game Profile Name:</p><input  class="cng-email" type="text" placeholder="Game Name" name="gname" value="<%=rst.getString(4)%>" required="required" ><br><br>
                 </center> </td>
                 <td></td><td>
                 <center>
  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Game Id:</p><input  class="cng-email" type="text" value="<%=rst.getString(5)%>" placeholder="Game Id" name="gid" required="required" ><br><br>
                 </center> </td>
                 </tr>
             <tr>
                 <td>    
             <center>
  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Address:</p><input  class="cng-email" type="text" placeholder="House No/Street No/Floor" value="<%=rst.getString(6)%>" name="house" required="required" ><br><br>
                 </center> 
  <input  class="cng-email" type="text" placeholder="State" value="<%=rst.getString(7)%>" name="state" required="required" ><br><br>
    <input  class="cng-email" type="text" placeholder="City" value="<%=rst.getString(8)%>" name="city" required="required" ><br><br>
      <input  class="cng-email" type="text" placeholder="Pin Code" value="<%=rst.getString(9)%>" name="pin" required="required" ><br><br>
   </td>
   <td></td><td>
                 <center>
  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Age:</p><input  class="cng-email" value="<%=rst.getString(10)%>" type="number" placeholder="Age" name="age" required="required" ><br>
  <p style="font-family: sans-serif;font-size: 20px;">Gender:
  </p><input  type="radio" checked="checked" name="gender" value="male" required="required" ><a style="font-family: sans-serif;font-size: 16px;">  Male</a>
  <input  type="radio"  name="gender" value="female" required="required" ><a style="font-family: sans-serif;font-size:15px;"> FeMale</a><br><br>
                 </center> </td>
                 </tr>
             </table><br>
            
             <button type="submit" class="cng-mail-button" style="margin-left: 300px;font-family: sans-serif;font-size: 20px;">Update Profile</button><br>

         </form>
            </div>
    </center>
    
   
    </body>
    <% } }%>
</html>
