<%@include file="adminheader.jsp"%>
<% if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<html>
    <head>
        <style>
            .battles-but
            {
                height:50px;
                width:200px;
                font-size: 20px;
            }
        </style>
    </head>
<body bgcolor='black'>
    <br><br><br>
    <button onclick="location.href='admindetails'" class="battles-but">Admin Details</button><br><br>
    <button onclick="location.href='addadmin.jsp'" class="battles-but">Add New Admin</button><br><br>
</body>
</html>
