<%@include file="header.jsp"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <script>
            function disp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="block";
            }
                        function ndisp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="none";
            }
            </script>
    </head>
    <body >
         <%if(session.getAttribute("email")==null)
    { response.sendRedirect("login.jsp");} %>
   <% 
Connection con=dao.getConnection();
       Statement stmt=con.createStatement();
       String email=(String)session.getAttribute("email");
       ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
if(rs.next()){%>
<br><br><br><br>
<% if(request.getParameter("status").equals("1") ){ %>
        <div class="profiletab">
            <center> 
                <input type="text" value="Email"/>
        <input type="submit" value="Update" />
            </center>
        </div> 
      <%  } else if (request.getParameter("status").equals("2")) { %>
 <div class="profiletab">
            <center> 
                <input type="text" value="Password"/>
        <input type="submit" value="Update" />
            </center>
        </div> 
      <% } else { %>
          <div class="profiletab">
            <center> 
                <input type="text" value="Name"/>
        <input type="submit" value="Update" />
            </center>
        </div> 
 <% }%>   
    
    
    
        <div class="footer" style="margin-top: 600px;">
            <br><center>
                <div style="margin-left:20px;;">
                    <a href="#" class="foot">Contact us</a><br>
                    <a href="#" class="foot">About us</a><br>
                    <a href="#" class="foot">Feedback</a><br>
                    <a href="home.jsp" class="foot">Home</a><br>
                <a href="login.jsp" class="foot">Login</a>
                </div> 
            </center>
        
            <div style=" color:white;">
                Global | India
            </div>
                <b style="color:white;">
                    <center><br>
                <div style="border-bottom: 2px solid black; width:90%;">
                </div><br>
                <b style="color:white;">
                Follow Us On Social Media<br>
                <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.facebook.com/">  <i class="fa fa-facebook-official"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;"  href="https://www.twitter.com/">  <i class="fa fa-twitter"></i></a>
              <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.instagram.com/">   <i class="fa fa-instagram"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://plus.google.com/">  <i class="fa fa-google-plus"></i></a>
               <a style="font-size:30px;color:white; text-decoration: none;" href="https://www.gmail.com/">  <i class="fa fa-envelope"></i></a>
                <br> <i class="fa fa-copyright">  2019 Battlesround</i>
            </center>
              </b>
        </div>
    </body>
    <% } %>
</html>
