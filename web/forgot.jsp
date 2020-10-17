<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="newcss.css" rel="stylesheet" tyle="text/csss">
    </head>
<body background="photos/190945.png">
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;">
            <p style="font-family: sans-serif;font-size:50px;color:white;">Forgot Password</p>
         <form action="forgot" method="post">
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your Registered Email:</p>
             <input  class="cng-email" type="email" placeholder="Email" name="email" required="required"><br><br><br>
            
            <button type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;" >Forgot Password</button><br><br>
         </form>
            </div>
    </center>
    
   
    </body>
</html>
