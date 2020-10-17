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
       Statement st=con.createStatement();
       String email=(String)session.getAttribute("email");
ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){
ResultSet rst=st.executeQuery("select * from profile where email='"+email+"'");
if(rst.next())
{
       %>
      <script>
          function chk()
          { var e=<%=rst.getString(12)%>;
          var amt=document.getElementById("amt").value;
          if(amt>e)
          {    alert("Invalid amount");
              return false;
          }
           if(amt<=0){
              alert("You don't have enough Amount");
              return false;
          }
          if(amt<50)
          { alert("You don't have enough Amount ");
              return false;
          }
          return true;
              
          }
            </script>
    </head>
  <body background="photos/190945.png">
<br><br><br><br>
    <center>
        <div class="profiletab-redeem" id="profiletab" style="border-bottom-right-radius: 40px;border-bottom-left-radius:40px;"><br><br>
         <img src="<%=rs.getString(5)%>" onclick="location.href='#'" height="200px" class="profile-redeem" width="200px">
         <a>Redeem Rewards
         </a>
         <form action="redeem2.jsp" method="post" onsubmit="return chk();">
             <p style="font-family: sans-serif;font-size: 20px; color:red;">Minimum Redeem Amount 50 Coins</p>
             <b style="font-family: sans-serif;font-size: 20px;">Your Coins: </b><input  class="cng-email" id="amt" type="text" name="amt" value="<%=rst.getString(12)%>" required="required" ><br><br>
             <input type="submit" class="cng-mail-button" style="font-family: sans-serif;font-size: 20px;" value="Continue"><br>
 
         </form>
            </div>
    </center>
    </body>
    
    <% } }%>
</html>
