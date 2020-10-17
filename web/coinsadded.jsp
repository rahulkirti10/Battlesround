<%@page import="battlesround.dao"%>
<%@include file="header.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<% String status=request.getParameter("status");  %>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="payment.css" rel="stylesheet" tyle="text/csss">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" media="mediatype and|not|only (expressions)" href="print.css"> 
        <link rel = "icon" href =  "photos/titlelogo.png" type = "image/x-icon"> 
           <title>battlesround</title> 
           <script>    
            function view(e)
            {
          document.getElementById("purchase1").innerHTML="BUY FOR <i class='fa fa-inr' aria-hidden='true' style='font-size:25px;'></i> "+e;
            }
               </script>
    </head>
   
    <body background="photos/190945.png">
         <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
   <% 
if(status.equals("2"))
{
       %>
       <br><br><br>
    <center>
 <div class="success">
     <p class="success-tick"> <i class="fa fa-check-circle" aria-hidden="true"></i></p>
       <p class="success-payment">Payment SuccessFull</p>
       <p class="success-payment1">Your BattleCoins  <img class="coins" src="photos/coin.png" style='height:20px; width:20px;'> is Successfully Added to your Wallet.</p>
       <p class="success-payment2">Click <a href="battlesline.jsp">Here</a> to Start Your Battles. </p>
       <img class="success-img" src="photos/logo.png">
 </div>
        <% } else
{ %>
 <br><br><br>
    <center>
 <div class="success">
     <p class="unsuccess-tick"> <i class="fa fa-times-circle" aria-hidden="true"></i><p>
       <p class="unsuccess-payment" style="color:red;">Payment UnSuccessFull</p>
       <p class="unsuccess-payment1"><%=request.getParameter("error")%></p><br>
       <p class="unsuccess-payment1">If Your Amount is Debited By Your Bank and Your Payment is Declined due to Some Reason. So don't Worry Your Amount is Refund within 7-14 Business Days.</p>
       <p class='unsuccess-payment1'>-----For More Queries Contact Rahulkirti10@gmail.com------</p>
       <img class="unsuccess-img" src="photos/logo.png">
 </div>
        <% } %>


    </center>
</body>
</html>
