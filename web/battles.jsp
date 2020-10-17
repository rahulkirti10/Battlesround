<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="header.jsp"%>
<%   
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
                <a href="battles.jsp?db=<%=request.getParameter("db")%>" class="battles-href"><i class="fa fa-gamepad" aria-hidden="true"></i> UPCOMING</a>
                <a href="result.jsp?db=<%=request.getParameter("db")%>" class="battles-href"><i class="fa fa-envelope-open" aria-hidden="true"></i> RESULTS</a>
            </center>
                <div class="underline"></div>
        </div>
    <center>
        <% 
               Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
String strDate = ft.format(dNow);
SimpleDateFormat ftt = new SimpleDateFormat ("hh");
 String d=ftt.format(dNow);
 SimpleDateFormat mm = new SimpleDateFormat ("mm");
 String m=mm.format(dNow);
            while(rs.next())
        {
         String time=rs.getString(8);
            int t1=0,s1=0,t2=0,s2=0;
            String tt1=String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1));
            t1=Integer.parseInt(tt1);
            String ss1=String.valueOf(time.charAt(3))+String.valueOf(time.charAt(4));
            s1=Integer.parseInt(ss1);
            String tt2=String.valueOf(time.charAt(9))+String.valueOf(time.charAt(10));
            t2=Integer.parseInt(tt2);
            String ss2=String.valueOf(time.charAt(12))+String.valueOf(time.charAt(13));
            s2=Integer.parseInt(ss2);
            int curtime=Integer.parseInt(d);
            int curmin=Integer.parseInt(m);
            if(curtime==t1&&curmin>=s1||curtime==t2&&curmin<=s2)
            {
            }
            else
            {
                if(rs.getString(14).equals("NO"))
                {
            Statement stm=con.createStatement();
            ResultSet rst=stm.executeQuery("select count(*) from battle_registration where battle_id='"+rs.getString(1)+"'");
            %>
            
    <script> 
        function showd<%=rs.getString(1)%>()
            {
                var e=document.getElementById("cancel<%=rs.getString(1)%>");
                e.style.display="block";
            }
            function noshow<%=rs.getString(1)%>()
            {
                var e=document.getElementById("cancel<%=rs.getString(1)%>");
                e.style.display="none";
            }
           </script>
        <div class="battles">
            <form action="battlesdetails.jsp" method="post">
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
                   <% if(rst.next())
                    {  %>
                             

                    <p class="b-left">Only <b><%=95-rst.getInt(1)%></b> registration left</p>
                     <p class="b-left1"><%=rst.getInt(1)%>/95</p>
                    
              <% 
                if(rst.getInt(1)>=95)
                {
                    %>
             <input  class="already-register" style='background-color: red;' type="button" value="Registration Full">    
                
             <%       
                 }
else
{
                  Statement st=con.createStatement();
                    ResultSet rt=st.executeQuery("select * from battle_registration where email='"+email+"'");
                    int flag=0;
                  while(rt.next())
              {
                  if(rs.getString(1).equals(rt.getString(3)))
                                {
                   flag=1;
                   break;
                                }
                  else
                  {
                      flag=0;
                  }
              }
                  if(flag==1)
                  {
              %>
  
              <input  class="already-register" type="button" value="Already Join">
               <input type='button' class="already-register" style="background-color:maroon;color:white;" onclick='showd<%=rs.getString(1)%>()'value='Cancel Joining' />              
                   <% }
                       else
                       {
                               
%>                    <input  class="register" type="submit" value="Register">
<% }
}
}
%>
            </form>
        </div>
       <div class="cancel" id="cancel<%=rs.getString(1)%>">
        <br>
        <center> <p> <i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Are you Sure You Want to Cancel Your registration for Battles.</p>  
            <br><br>
            <form action='cancel' method='post'>   
                <input type='hidden' name='id' value='<%=rs.getString(1)%>' />
                <input type="button" onclick="noshow<%=rs.getString(1)%>()" value="Cancel" class="cancel-button">
            <input type="submit" value="Yes"  class="cancel-button">
            </form>             
        </center>
    </div>
            <% }}
} %>
    </center>   
    </body>
</html>
