<%@include file="header.jsp"%>
<%   
    Connection con=dao.getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from battle_display where b_id='"+request.getParameter("bid")+"'");
    
    %>
<html>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="battles.css" rel="stylesheet" tyle="text/csss">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel = "icon" href =  "photos/titlelogo.png" type = "image/x-icon"> 
           <title>battlesround</title> 
    </head>
  
    <body background="photos/190945.png">
        <% 
            while(rs.next())
        {
            %>
        <div class="battles-details">
            <img src="<%=rs.getString(9)%>" class="battles-details-images" >  
            <p class="battlesline-type"><%=rs.getString(3)%> Battle</p>
                                        <input type="hidden" value="<%=rs.getString(1)%>" name="bid">
                  <div class="details">
                  </div>
                                        
                    <div class="all-details">
                        <p class="battlesline-id"><%=rs.getString(12)%>-Battle Id: #<%=rs.getString(1)%></p>
                                    <li>Version: <%=rs.getString(4)%></li><br>
                                    <li>Map: <%=rs.getString(6)%></li> <br> 
                                    <li>Battle Type: Paid</li><br>
                                    <li>Battle Schedule: <%=rs.getString(11)%> at <%=rs.getString(8)%></li><br>
                             <input type="hidden" value="<%=rs.getString(7)%>" id="fee"/>       <li>Battle Fee: <%=rs.getString(7)%> <img class="coins" src="photos/coin.png"></li><br>
                        <p class="battlesline-id">Rewards Details</p>
                        <li>Winner Winner - Chicken dinner: <%=rs.getString(13)%> <img class="coins" src="photos/coin.png"></li><br>
                        <li>Per Kill: <%=rs.getString(10)%> <img class="coins" src="photos/coin.png"></li><br>
                        <li>Total Rewards:<%=rs.getInt(10)*94%> <img class="coins" src="photos/coin.png"></li>    
                        <br><br>
                        <center>
                    <table width="100%" border="1">
                        <tr><th>Email</th>
                            <th>Game Name</th>
                            <th>Game Id</th>
                            <th>Kills</th>
                            <th>Rank</th></tr>
                        <%
                            Statement stm=con.createStatement();
                            ResultSet rst=stm.executeQuery("select * from battle_registration where battle_id='"+request.getParameter("bid")+"' order by rank asc");
                          while(rst.next())
  { %>
                        <tr><td><center><%=rst.getString(2)%></center></td>
                    <td><center><%=rst.getString(8)%></center></td>
                    <td><center><%=rst.getString(9)%></center></td>
                        <td><%=rst.getString(5)%></td><td><%=rst.getString(10)%></td>
                        </tr>   
  
  
<%  }  %>
                    </table>  
                        </center>
                    </div>
        </div>
            <% } %>  
    </body>
</html>
