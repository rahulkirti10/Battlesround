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
       Statement stmt=con.createStatement();
       Statement st=con.createStatement();
       String email=(String)session.getAttribute("email");
       String bid=request.getParameter("bid");
       Statement stm=con.createStatement();
       ResultSet r=stm.executeQuery("select * from battles where b_id='"+bid+"'");
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
       ResultSet rst=st.executeQuery("select * from profile where email='"+email+"'");
   while(rst.next()&&r.next())
           { 
       if(rst.getInt(12)<r.getInt(7))
            {
%>
<br><br><br><br><br>
    <center>
 <div class="purchase">
    <img src="photos/wallet.gif" height="200px" width="200px"> 
    <P class='purchase1'>Your  Current Balance: <%=rst.getString(12)%> <img class="coins" src="photos/coin.png" style='height: 25px; width:25px;'> </P>
    <p class='purchase1'>Battle Fee: <%=r.getString(7)%> <img class="coins" src="photos/coin.png"  style='height: 25px; width:25px;'></p>
    <p class='purchase1' style='color:red; font-size: 18px;'>You don't have enough Battle Coins.</p>
    <p class='purchase1' style='color:red; font-size: 18px;'>Kindly purchase some Battle Coins for joining the Battle.</p>
    <input type='button' value='CANCEL' class='buy' onclick="location.href='battlesdetails.jsp?bid=<%=r.getString(1)%>'">&nbsp;&nbsp;&nbsp;
    <input type='button' value='BUY BATTLECOINS' class='buy'>
 </div>
    </center>

    <%
 } else
{ %>

<br><br> 
<center>
    <div class="profiletab" id="profiletab" ><br>
         <form action="battle" method="post" onsubmit="return chk();">
             <p class="battlesline-id"><%=r.getString(12)%>-Battle Id: #<%=r.getString(1)%></p>       
<p class='purchase1'>Battle Fee: <%=r.getString(7)%> <img class="coins" src="photos/coin.png"  style='height: 25px; width:25px;'></p>
<p class='purchase1'>Map: <%=r.getString(6)%> </p>
             <p style="font-family: sans-serif;font-size: 20px;">Enter Your Game Profile Name:</p><input  class="cng-email" style="background-color:white;" value="<%=rst.getString(4)%>" type="text" placeholder="Game Name" name="gname" required="required" ><br>

  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Game Id:</p><input  class="cng-email" type="text" style="background-color:white;" value="<%=rst.getString(5)%>" placeholder="Game Id" name="gid" required="required" ><br>

  <p style="font-family: sans-serif;font-size: 20px;">Enter Your Age:</p><input  class="cng-email" type="number" style="background-color: white;" placeholder="Age" name="age" required="required" ><br>
  <p style="font-family: sans-serif;font-size: 20px;">Gender:
  <input  type="radio" checked="checked" name="gender" value="male" required="required" ><a style="font-family: sans-serif;font-size: 16px;">  Male</a>
  <input  type="radio"  name="gender" value="female" required="required" ><a style="font-family: sans-serif;font-size:15px;"> FeMale</a><br><br>
  <input type="hidden" value="<%=r.getString(1)%>" name="bid">
  <input type="hidden" value="<%=request.getParameter("db")%>" name="db">
  <button type="submit" class="buy" >Join <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button><br>

         </form>
            </div>
    </center>
 <%   
}
}  %>
</body>
</html>
