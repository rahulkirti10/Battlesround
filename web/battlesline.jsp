<%@page import="battlesround.dao"%>
<%@include file="header.jsp"%>
<%   
    Connection con=dao.getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from battlesline");
    
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
    <center>
        <% 
            while(rs.next())
        {
            %>
        <div class="battlesline">
            <form action="battles.jsp" method="post">
                <img src="<%=rs.getString(4)%>" class="battlesline-images" onclick="location.href='battles.jsp?db=<%=rs.getString(3)%>'">  
            <input type="hidden" value="<%=rs.getString(3)%>" name="db">
                    <input  class="battlesline-register" type="submit" value="<%=rs.getString(2)%>">
            </form>
        </div>
            <% } %>
    </center>   
    </body>
</html>
