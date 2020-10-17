<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
        <% String email=request.getParameter("email"); %>
    </head>
<body background="photos/190945.png">
      
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px; height: 350px;"><br><br>
         <form action="forgotpass" method="post" >
             <input type="hidden" name="email" value="<%=email%>">
              <p style="font-family: sans-serif;font-size: 20px;">Enter Your New Password:</p><input  class="cng-email" type="text" placeholder="New Password" required="required" name="pass"><br><br>
             
             <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;" >Change Password</button><br>
             <p id="wrong" style="color:red;font-size: 15px; display: none;"></p>
         </form>
            </div>
    </center>
    
   
    </body>
</html>
