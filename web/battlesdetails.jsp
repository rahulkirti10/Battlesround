<%@include file="header.jsp"%>
<%   
    Connection con=dao.getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from battles where b_id='"+request.getParameter("bid")+"'");
    
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
            <form action="battles_registered.jsp" method="post">
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
                        <p class="battlesline-id">About This Battle</p>
                        <li>New PUBG Accounts are not Allowed.PUBG Accounts with Level Less than 30 are not allowed to Participate.Those Participants will be kicked out from the room and they will not be given refund.</li>
                        <li>Mkae sure to update/download Miramar,sanhok and vikendi maps before joining the Battles. No refund in case you fail or forget to download.</li>
                        <li>If Anyone fail to join the room without Cancel the Registration then we aren't responsible for it.In such cases Refund won't be processed. So make sure to enter on time.</li>
                        <li>Room Id and Password will be shared in our website or app and your Registered email's before 20 minutes of battle start time.</li>
                        <li>Please Do not share the Room Id & Password with anyone who has not registered the Battle. If you are found doing that, your Account may be terminated.</li>
                        <li>Battle will start after 20 minutes of sharing Room Id and Password.</li>
                        <li>Make sure to grab Room Id and Password before the Battle Start Time.</li>
                        <li>Any Participant found doing Teaming so it will be disqualified and their rewards will be lost.</li>
                        <li>Make sure you enter the Room As Soon As Possible, before the Battle starts.</li>
                        <li>once you enter the room, do not change your position many times. If you do so, you may kick out from the room.</li>
                        <li>Registration are given on the First come First Basis.</li>
                        <li>Anyone found using Screencast will be banned instantly without any warnings.</li>
                        <li>If Anyone found Hacks or cheat while playing game at Battlesround, their account will be terminated and no rewards will be given.</li>
                        <li>Use only Mobile Devices to join Battles.Do not use Emulators. </li>
                        <li>If Anyone cancel their Registration, their Battle coins will be refund to their Accounts. </li>
                        <li>If Anyone found violating these Rules then immediate actions will be taken and respective accounts may be terminated or banned and rewards may be abandoned.</li>
                   
                    </div>   
                        <input type="hidden" value="<%=request.getParameter("db")%>" name="db">
                        <button type='submit' class="join">Join <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
            </form>
                    
        </div>
            <% } %>  
    </body>
</html>
