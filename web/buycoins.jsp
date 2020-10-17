<%@page import="battlesround.dao"%>
<%@include file="header.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="battles.css" rel="stylesheet" tyle="text/csss">
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
<br><br><br><br><br>
    <center>
 <div class="purchase">
     <form action="buycoins" method="post">
    <img src="photos/wallet.gif" height="200px" width="200px"> 
    <P class='purchase1'>Choose BattleCoins:<br><br>
        <select name="amount" class="amount" onchange="view(this.value);" required="required">
            <option value="">Select</option>
            <% int n=5;while(n<=100)
            {
                %>
            <option value="<%=n%>"><%=n%> </option>    
                
           <% n+=5; }  %>
        </select>&nbsp;<img class="coins" src="photos/coin.png" style='height:40px; width:40px;'> </p>
    <p class="purchase1" id="purchase1" style="color:green"></p>
    <input type='submit' value='BUY BATTLECOINS' class='buy'><br><br>
     </form>
 </div>
    </center>
</body>
</html>
