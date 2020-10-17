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
              
               </script>
    </head>
   
    <body background="photos/190945.png">
         <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
   <% 
Connection con=dao.getConnection();
       Statement st=con.createStatement();
       String email=(String)session.getAttribute("email");
       ResultSet rst=st.executeQuery("select * from profile where email='"+email+"'");
       if(rst.next())
            {
%>
<br><br><br><br><br>
    <center>
 <div class="purchase">
    <img src="photos/wallet.gif" height="200px" width="200px"> 
    <P class='purchase1' style="font-size:30px; color:green;"><b>BattleCoin Wallet</b></P>
    <P class='purchase1'>Your  Current Balance: <%=rst.getString(12)%> <img class="coins" src="photos/coin.png" style='height: 25px; width:25px;'> </P>
    <input type='button' value='BUY BATTLECOINS' onclick="location.href='buycoins.jsp'" class='buy'><br><br>
    <input type='button' value='VIEW TRANSACTION' class='buy' onclick="location.href='transaction.jsp'">
 </div>
    </center>
<% } %>
</body>
</html>
