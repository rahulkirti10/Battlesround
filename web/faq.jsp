<%@include file="header.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<% Connection con=dao.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from faq where sno='"+request.getParameter("q")+"'");
%>
<html>
    <body background="photos/190945.png">
        <br><br><br>
        <div class="ans">
            <% if(rs.next())
            {
                %>
            <p style="color: white; font-family: sans-serif;font-size: 30px;"><%=rs.getString(2)%></p>
            <p Style="color:white;font-family: sans-serif;font-size:20px;">Ans. <%=rs.getString(3)%></p>
            <% }%>
        </div>     
        <div class="footer-foot">
             <br><center>
                 <div class="footer-img">
                     <img src="photos/logo.png" height="80px" width="250px">
                 </div>
                <div style="margin-left:20px;;">
                    <a href="#" class="foot">Contact us</a><br>
                    <a href="#" class="foot">About us</a><br>
                    <a href="#" class="foot">Feedback</a><br>
                    <a href="home.jsp" class="foot">Home</a><br>
                <a href="#" class="foot">Login</a>
                </div> 
             </center>
                 <div>
                     <p style="position: absolute;color:white;font-size:30px;right:300px;top:-20px;">Information</p>
                     <p style="position: absolute;color:white;font-size:17px;right:156px;top:30px;">BattlseRound:-The Best eSports Platform<br>If you are Passionate about Online Games<br> and Have you ever thought of earning<br> through Online Gaming or from Playing<br> Mobile0 Games? So Battlesround is the<br> best Platform who makes this possible.</p>
                 </div>
    
              <b style="color:white;">
                  <center><br><br><br><br>
                <div style="border-bottom: 2px solid black; width:90%;">
                </div><br>
                Follow Us On Social Media<br>
                <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.facebook.com/">  <i class="fa fa-facebook-official"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;"  href="https://www.twitter.com/">  <i class="fa fa-twitter"></i></a>
              <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.instagram.com/">   <i class="fa fa-instagram"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.gmail.com/">  <i class="fa fa-envelope"></i></a>
                <br> <i class="fa fa-copyrigh">All the Logos, Trademarks and Images belongs to their Respective Owner</i>
            </center>
              </b>
        </div>
    </body>
</html>