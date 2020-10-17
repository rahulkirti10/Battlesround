<%@include file="header.jsp"%>
<%   
    if(session.getAttribute("email")==null)
    {
        response.sendRedirect("login.jsp");
    }
    String email=(String)session.getAttribute("email");
    Connection con=dao.getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from "+request.getParameter("db"));

    %>
<html>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="battles.css" rel="stylesheet" tyle="text/csss">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" media="mediatype and|not|only (expressions)" href="print.css"> 
        <link rel = "icon" href =  "photos/titlelogo.png" type = "image/x-icon"> 
           <title>battlesround</title> 
    </head>
    <body background="photos/190945.png">
        <br><br><br><br>
        <div class="battles-nav">
            <br>
            <center>
                <a href="ongoing.jsp?db=<%=request.getParameter("db")%>" class="battles-href"><i class="fa fa-clock-o" aria-hidden="true"></i> ONGOING</a>
                <a href="battles.jsp?db=<%=request.getParameter("db")%>" class="battles-href"><i class="fa fa-gamepad" aria-hidden="true"></i> UPGOING</a>
                <a href="result.jsp?db=<%=request.getParameter("db")%>" class="battles-href"><i class="fa fa-envelope-open" aria-hidden="true"></i> RESULTS</a>
            </center>
                <div class="underline-result"></div>
        </div>
    <center>
        <% 
            while(rs.next())
        {
            if(rs.getString(14).equals("YES"))
            {
            Statement stm=con.createStatement();
            ResultSet rst=stm.executeQuery("select count(*) from battle_registration where battle_id='"+rs.getString(1)+"'");
            %>
        <div class="battles">
            <form action="battleresult.jsp" method="post">
            <img src="<%=rs.getString(9)%>" class="battles-images" >   
                    <p class="type"><i class="fa fa-user-o" aria-hidden="true"></i> <%=rs.getString(3)%></p>
                    <p class="map"><i class="fa fa-location-arrow" aria-hidden="true"></i> <%=rs.getString(6)%></p>
                    <p class="tpp"> <%=rs.getString(4)%></p>
                    <p class="time"><i class="fa fa-clock-o" aria-hidden="true"></i> <%=rs.getString(8)%></p>
                    <p class="match"> <%=rs.getString(2)%></p>
                    <p class="fees">Battle Fee: <%=rs.getString(7)%><img class="coins" src="photos/coin.png" style="height:22px; width: 22px;"></p><br>
                    <input type="hidden" value="<%=rs.getString(1)%>" name="bid">
                    <p class="name"><%=rs.getString(12)%></p><br>
                    <p class="b-match">Match:<b> <%=rs.getString(5)%></b></p><br>
                    <p class="b-match" style="top:46%;">Battle Id:<b> #<%=rs.getString(1)%></b></p><br>
                    <p class="b-match" style="top:52%;">Per Kill:<b><%=rs.getString(10)%></b> <img class="coins" src="photos/coin.png"></p><br>
                    <p class="b-match" style="top:58%;">Total Prize:<b> <%=rs.getInt(10)*95%></b>  <i class="fa fa-inr" aria-hidden="true"></i></p><br>
                   <p class="time" style="top:2%;">Date: <%=rs.getString(11)%></p><br>
                   <input type="hidden" value="<%=request.getParameter("db")%>" name="db"> 
                   <button class="result" style='background-color:#30497E; m' type="submit"><b style="color:white;">See Result</b></button>    
            </form>
        </div>
            <% }} %>
    </center>   
    </body>
</html>
