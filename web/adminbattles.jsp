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
    <button onclick="location.href='registration'" class="battles-but">Registration of battles</button><br><br>
    <button onclick="location.href='battledisplay'" class="battles-but">battles for users</button><br><br>
    <button onclick="location.href='viewbattles'" class="battles-but">battles</button><br><br>
    <button onclick="location.href='addbattles.jsp'" class="battles-but">Add new battles</button>
</body>
</html>
