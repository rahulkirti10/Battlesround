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
       <script>
           function chk()
           {
               if(document.getElementById("acc").value==document.getElementById("racc").value)
                   return true;
               else
                   alert("Account No. are not match");
               return false;
           }
           
           </script>
    </head>
<body background="photos/190945.png">
      
   <% 
ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){%>
<br><br><br><br>
    <center>
        
         <% if(request.getParameter("amt").equals("paytm"))
         {%>
         <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px">
         <form action="redeem" method="post">
             <input type="hidden" value="<%=request.getParameter("amount")%>" name="amount"> 
             <input type="hidden" value="<%=request.getParameter("amt")%>" name="amt"> 
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your Paytm Registered Mobile No. :</p><input  class="cng-email" type="text" placeholder="Paytm No." name="acc" required="required" ><br>
             <br>
             <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;">Proceed to request</button><br>
         </form>
              </div>
             <% } else if(request.getParameter("amt").equals("bank")) { %>
             <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px; height:500px;border-bottom-left-radius:40px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px">
             <form action="redeem" method="post" onsubmit="return chk();">
             <input type="hidden" value="<%=request.getParameter("amount")%>" name="amount"> 
             <input type="hidden" value="<%=request.getParameter("amt")%>" name="amt"> 
             <br>
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your Bank Account No. :</p><input  class="cng-email" type="password" placeholder="Account No." name="acc" id="acc" required="required" ><br>
             <p style="font-family: sans-serif;font-size: 20px;">Retype Your Bank Account No. :</p><input  class="cng-email" type="text" placeholder="retype Account No." id="racc" name="racc" required="required" ><br>
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your IFSC Code :</p><input  class="cng-email" type="text" placeholder="Ifsc Code" name="ifsc" required="required" ><br>
             <br>  <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;">Proceed to request</button><br>
         </form>
              </div>
             <% } %>
           
    </center>
    
   
    </body>
    <% } %>
</html>
