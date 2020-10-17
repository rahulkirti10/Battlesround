<%@include file="adminheader.jsp"%>
<% if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<body bgcolor='black'>
    <br><br><br>
<center>
    <div style="color:white;">
        <h1>New Admin Form</h1>
        <form action="addadmin" method="post">
            Enter Email: <input type="text" name="email" required="required" style="width:300px;height:30px;"><br><br>
        Enter password: <input type="text" name="pass" required="required"  style="width:300px;height:30px;"><br><br>
        Enter Name: <input type="text" name="name" required="required" style="width:300px;height:30px;"><br><br>
        Enter Google Id: <input type="text" name="gid"  required="required" style="width:300px;height:30px;"><br><br>
        <input type="submit" value="submit">
        </form> 
        </div>    
</center>
</body>