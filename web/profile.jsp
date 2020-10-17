<%@include file="header.jsp"%>
<%@include file="cng_photo.jsp" %>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script>
            function disp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="block";
               e=document.getElementById("profiletab");
               e.style.display="none";
                e=document.getElementById("profiledown");
               e.style.display="none";
  
  
            }
                        function ndisp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="none";
                e=document.getElementById("profiletab");
               e.style.display="block";
                e=document.getElementById("profiledown");
               e.style.display="block";
            }
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
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){  
   ResultSet rst=st.executeQuery("select * from profile where email='"+email+"'");
   if(rst.next())
{
%>
<br><br><br><br><br>
  <center>
<div class="profile-div" id="profile-div"> 
    <div class="profiletab-profile" ><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile" width="200px"><br>
            <a  onclick="disp()" href="#" class="cng">Change Photo</a> 
            <div class="personal-profile">
                <li><b><%=rst.getString(3)%></b></li><br>
                 <li><%=rst.getString(2)%></li><br>
                 <li>User Id:<%=rs.getString(1)%></li> 
                </div>
                <div class="about" onclick="location.href='statistics.jsp'">
                    <div class="abt"><b style="color:blue;"><%=rst.getString(13)%></b><br> Matches Played</div><div class="line"></div>
                    <div class="abt"><b style="color:blue;"><%=rst.getString(14)%></b><br>Total Kills</div><div class="line"></div>
                    <div class="abt"><b style="color:blue;"><%=rst.getString(15)%></b>  <img class="coins" src="photos/coin.png" style='height:20px; width:20px;'><br>Winnings </div> 
                </div>

    </div>
            <div class="profiledown" id="profiledown"><br><br>
               <button class="profiletabl" onclick="location.href='personalprofile.jsp'"><i class="fa fa-user" aria-hidden="true" style="font-size: 30px;"></i> My Personal Profile</button><br><br>
               <button class="profiletabl" onclick="location.href='redeem.jsp'"><i class="fa fa-inr" aria-hidden="true" style="font-size: 30px;"></i> Redeem Rewards</button><br><br>
               <button class="profiletabl" onclick="location.href='coin.jsp'">  <img class="coins" src="photos/coin.png" style='height:25px; width:25px;border-radius: 12px;'> My Coins</button><br><br>
               <button class="profiletabl" onclick="location.href='statistics.jsp'"><i class="fa fa-line-chart" aria-hidden="true"></i> My Statics</button><br><br>
               <button class="profiletabl" onclick="location.href='contactus.jsp'"><i class="fa fa-volume-control-phone" aria-hidden="true"></i> Customer Support</button><br><br>
                <button class="profiletabl"  onclick="location.href='setting.jsp'"><i class="fa fa-cog" aria-hidden="true" style="font-size: 30px;"></i> Setting</button><br><br>
               <button class="profiletabl" onclick="location.href='logout'"><i class="fa fa-sign-out" aria-hidden="true" style="font-size: 30px;"></i> Logout</button>
            </div> 
</div>
    </center>
       </body>
    <% } }%>
 
</html>
