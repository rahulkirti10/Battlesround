<%@include file="header.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <body background="photos/190945.png">
        <div class="heading-div">
        <div class="heading">
            <center>
                <h1 >Battles<b style="color:black;">round</b></h1>
            </center>
           </div> 
         <div class="inf">   
             <div class='inf-inf'>
        <a>The Best eSports
            Platform</a><br><br>
            <p>If you are Passionate about Online Games and  Have you ever thought of earning through Online Gaming or from Playing Mobile Games? So Battlesround is the best Platform who makes this possible. It is easy to join, Big Rewards, some Free Battles, Top 10 Runner ups Rewards and more Exciting Rewards.  </p>
             </div>
            <br><br>
            <a href="#scroll"><button class="earn"><i class="fa fa-play" aria-hidden="true"></i> Play & Earn</button></a>
         </div>
        <br><br>
        <img  class="heading-img" src="photos/pngfind.com-pubg-character-png-3167986.png">
        </div>
        <br>
        <div class="next">
            <div class="available" id="scroll">
                       <img src="photos/drop.png" class="drop">
            <center><br><br>
                <a><b>Available Games Tournaments</b></a><br><br>
            <div class="avail-div">
                <br>
                <img src="photos/PUBGMobilelogo.png"   height="150px" width="150px"><br><br><br>
                <a style="color:white;font-size:20px;font-family:sans-serif;"><b>PUBG Moblie</b></a>
            </div>
                </center>
         </div> 
        </div>
        <div class="features">
            <center><br>
                <a style="color:white;font-size:40px;font-family:sans-serif;"><b>Our Cool Features</b></a><br>
                   
                <div class="small-features">
                    <br><br>
                 <a class="small-a" ><b>Free Tournaments</b></a><br><br>
                 <a class="small-a-next" >Enjoy and play Free Tournaments for practicing your talent with your Friends.</a><br><br>
                 <img src="photos/pubg_PNG6.png" height="70px" width="70px">  
                </div>
                <div class="small-features"><br><br>
               <a class="small-a""><b>Join Battles</b></a><br><br>
                <a class="small-a-next">Join Battles and Enjoy the Custom Battles Everyday.play well and get Rewarded. </a><br><br>
                 <img src="photos/pubg_PNG15.png" height="80px" width="80px">    
                </div>
       
                  <div class="small-features"><br><br>
               <a class="small-a"><b>start with just Rs.5</b></a><br><br>
                <a class="small-a-next">New Users get 5 BattleCoins Bonus. Add 5 BattleCoins and Start yout Earnings. </a><br><br>
                 <img src="photos/pubg_PNG4.png" height="70px" width="120px">     
                </div>
                <div class="small-features"><br><br>
                  <a class="small-a"><b>Rewards on Each Kill and Winning</b></a><br><br>
                  <a class="small-a-next">Get Rewards on Each Kill, top Runner up's and extra on Winning. Join weekend Battles for Bigger Rewards. </a><br>
                 <img src="photos/hiclipart.com (3).png" height="100px" width="130px">  
                </div>
                
                 <div class="small-features"><br>
                  <a class="small-a" ><b>Leaderboards and Live Streaming</b></a><br><br>
                  <a class="small-a-next">Top Players get Weekly Rewards and Watch your completed Battle and live at Youtube. Checkout our Battlesround Youtube Channel.  </a><br>
                 <img src="photos/pngguru.com.png" height="70px" width="90px">  
                </div>
                 <div class="small-features"><br>
                  <a class="small-a"><b>Play with your own Team</b></a><br><br>
                  <a class="small-a-next">Join Battles with your team and get Highly Rewards upto Rs. 4000. Also have Rewards for Top 10 Runner up's.</a><br>
                 <img src="photos/pubg-48217.png" height="120px" width="150px">  
                </div>
                 <div class="small-features"><br>
                  <a class="small-a"><b>Easy to use and Refund</b></a><br><br>
                  <a class="small-a-next">we make ease to join Battles. Refund of Battlecoins facility are also available.</a><br>
                 <img src="photos/pubg_PNG23.png" height="100px" width="100px">  
                </div>
                 <div class="small-features"><br>
                  <a class="small-a"><b>Get Rewards Directly in Paytm and Bank Account</b></a><br><br>
                  <a class="small-a-next">Exchange Your Battlecoins to your Paytm wallet and Directly to your Bank Account.</a><br>
                 <img src="photos/paytm2.png" height="60px" width="100px">  
                </div>
          </center>
            </div>
         <%
             Connection con=dao.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from faq");
            %>
            <br><br><br><br><br><br><br><br><br>
          <div class="faq-div">
        <div class="faq">
            <center>
                <p style="color: white;font-size:40px;font-family: sans-serif;">Frequently Asked Question</p>
            </center>
             <%   while(rs.next())
                {  %>
                <div class="que">
                    <a href="faq.jsp?q=<%=rs.getString(1)%>"><p style="color:white;font-family: sans-serif;">&nbsp;&nbsp;<%=rs.getString(2)%></p></a>
                </div>
                <% } %>  
        </div>
          </div>
         <div class="footer">
             <br><center>
                 <div class="footer-img">
                     <img src="photos/logo.png">
                 </div>
                <div class="link" style="margin-left:20px;;">
                    <a href="contactus.jsp" class="foot">Contact us</a><br>
                    <a href="#" class="foot">Feedback</a><br>
                    <a href="home.jsp" class="foot">Home</a><br>
                </div> 
                 <br><br>
             </center>
                 <div class="footer-inf">
                     <a>Information</a>
                     <p>BattlseRound:-The Best eSports Platform<br>If you are Passionate about Online Games<br> and Have you ever thought of earning<br> through Online Gaming or from Playing<br> Mobile0 Games? So Battlesround is the<br> best Platform who makes this possible.</p>
                 </div>
    
              <b style="color:white;">
                  <center><br><br><br><br>
                <div class="footer-line">
                </div>
                      <br>
                      <div class="social">
                Follow Us On Social Media<br>
                <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.facebook.com/">  <i class="fa fa-facebook-official"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;"  href="https://www.twitter.com/">  <i class="fa fa-twitter"></i></a>
              <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.instagram.com/">   <i class="fa fa-instagram"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.gmail.com/">  <i class="fa fa-envelope"></i></a>
                <br> <i class="fa fa-copyrigh">All the Logos, Trademarks and Images belongs to their Respective Owner</i>
                 </div>
            </center>
              </b>
        </div>
    </body>
</html>
