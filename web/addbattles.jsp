<%@include file="adminheader.jsp"%>
<% if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<body bgcolor='black'>
    <br><br><br>
<center>
    <div style="color:white;">
        <h1>New Battle Form</h1>
        <form action="addbattles" method="post">
            Enter Match: <input type="text" name="match" placeholder="eg: classic" required="required" style="width:300px;height:30px;"><br><br>
            select type: <select name="type" style="width:80px;height:30px;"><option value="Solo">Solo</option>
            <option value="Duo">Duo</option>
            <option value="Squad">Squad</option></select><br><br>
         select Player Type: <select name="p_type" style="width:80px;height:30px;"><option value="TPP">TPP</option>
            <option value="FPP">FPP</option></select><br><br>
        select map: <select name="map" style="width:80px;height:30px;"><option value="Erangle">Erangle</option>
            <option value="Miramar">Miramar</option>
            <option value="Sanhok">Sanhok</option>
        <option value="Vikendi">Vikendi</option></select><br><br>
        Enter Match type: <input type="text" name="match_type" required="required" placeholder="eg: Regular" style="width:300px;height:30px;"><br><br>
        Enter fee: <input type="text" name="fee" placeholder="eg: 10" required="required" style="width:300px;height:30px;"><br><br>
        Enter Time: <input type="text" name="time" placeholder="eg: 03:00 Pm-04:00 Pm" required="required" style="width:300px;height:30px;"><br><br>
        choose image <input type="file" name="img" style="width:300px;height:30px;"><br><br>
        enter per kill reward <input type="text" name="kill" placeholder="eg: 10" required="required" style="width:300px;height:30px;"><br><br>
        Enter Date: <input type="text" name="date" placeholder="eg: 05/03/2020" required="required" style="width:300px;height:30px;"><br><br>
        Enter Battle Name: <input type="text" name="name" placeholder="eg: duo clash" required="required" style="width:300px;height:30px;"><br><br>
        Enter winner reward: <input type="text" name="winner" placeholder="eg:50" required="required" style="width:300px;height:30px;"><br><br>
        <input type="submit" value="submit">
        </form> 
        </div>    
</center>
</body>