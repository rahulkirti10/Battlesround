<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%if(session.getAttribute("otp")==null&&session.getAttribute("email")==null)
response.sendRedirect("home.jsp");
        if(session.getAttribute("email")!=null)
        {
          response.sendRedirect("home.jsp");  
        }
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
        <title>Email Verification</title>
        <%
           String status=request.getParameter("status");
 String pass=(String)session.getAttribute("pass");
 String otp=(String)session.getAttribute("otp"); 
%> 
<script> 
    function fun()
    { var status=<%=status%>;
        if(status==1)
        { 
    var e=document.getElementById("c1");
    e.style.display="block";
        }
    }
            function chk()
            {
                var otp=<%=otp%>;
             if(document.getElementById("code").value==otp)
             {     return true;
             }
             else
             {
                 var e=document.getElementById("print");
                 e.style.display="block";
               document.getElementById("print").innerHTML="Invalid OTP"; 
           }
           return false;
            }
            function len()
            {
               var e=document.getElementById("print");
               e.style.display="none"; 
            }
            </script>
    </head>
    <body onload="fun()">
        <br><br><br><br>
    <center>       
    <div class="verify">
        <img src="photos/verifymail.png" height="330px" width="380px">
        <h1 style="font-family:sans-serif; margin-top:-80px;">Verify Your Email</h1>
        <p style="color:grey;margin-top:-20px;">An 6-digit code has been sent to <%=request.getParameter("email")%></p>
        <center>
            <form action="signup" method="post" onsubmit="return chk()">
           <input class="in" type="hidden" name="email"  value="<%=request.getParameter("email")%>">
           <input class="in" type="hidden" name="pass" value="<%=pass%>" >
           <input class="in" type="hidden" name="name" value="<%=request.getParameter("name")%>" >
           <input type="text" class="verify-text" name="otp" placeholder="OTP" id="code"  oninput="len()"  required="required">
           <div id="print" style="color:red;"></div>
           <p style="color:grey;margin-left:-120px;">Code is valid only for 5 minutes</p>
           <p style="color:grey;margin-left:-120px;">Didn't receive the code?<a href="verify_email?email=<%=request.getParameter("email")%>&name=<%=request.getParameter("name")%>" style="color:blue;text-decoration: none;">Resend</a> </p>
           <p id="c1" style="color:red;
              display:none">Code Resend Successfully</p>
           <input  class="signbutton" style="width:320px;" type="submit" value="verify" onclick="check()">   
       </form>
        </center>
           </div>
            </center>
        
        <div class="footer">
            <br><center>
                <div style="margin-left:20px;;">
                    <a href="#" class="foot">Contact us</a><br>
                    <a href="#" class="foot">About us</a><br>
                    <a href="#" class="foot">Feedback</a><br>
                    <a href="home.jsp" class="foot">Home</a><br>
                <a href="#" class="foot">Login</a>
                </div> 
            </center>
        
            <div style=" color:white;">
                Global | India
            </div>
                <b style="color:white;">
                    <center><br>
                <div style="border-bottom: 2px solid black; width:90%;">
                </div><br>
                <b style="color:white;">
                Follow Us On Social Media<br>
                <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.facebook.com/">  <i class="fa fa-facebook-official"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;"  href="https://www.twitter.com/">  <i class="fa fa-twitter"></i></a>
              <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.instagram.com/">   <i class="fa fa-instagram"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://plus.google.com/">  <i class="fa fa-google-plus"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.gmail.com/">  <i class="fa fa-envelope"></i></a>
                <br> <i class="fa fa-copyright">  2019 Battlesround</i>
            </center>
              </b>
        </div>
</body>
</html>
