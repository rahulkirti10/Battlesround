<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<%if(session.getAttribute("email")==null)
{}
else
{  
    response.sendRedirect("home.jsp");
}
%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link href="newcss.css" rel="stylesheet" tyle="text/csss">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" media="mediatype and|not|only (expressions)" href="print.css"> 
       <link rel = "icon" href =  "photos/titlelogo.png" type = "image/x-icon"> 
       <title>battlesround-Login</title>
  <meta name="google-signin-client_id" content="627015706208-greba33earobmauut54mahvjri97q6tu.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/client:platform.js" async defer></script>
</head>
<body onload="renderButton()" background="photos/wp1964365-pubg-4k-wallpapers.png">   
   <script type="text/javascript">
      function renderButton() {
    gapi.signin2.render('gSignIn2', {
        'scope': 'profile email',
        'width': 220,
        'height': 40,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
    });
}
    function onSuccess(googleUser) {
    gapi.client.load('oauth2', 'v2', function () {
        var request = gapi.client.oauth2.userinfo.get({
            'userId': 'me'
        });
        request.execute(function (resp) {
          var img=resp.picture;
          var email=resp.email;
          var name=resp.name;
          var gender=resp.gender;
          var id=resp.id;
          var auth2 = gapi.auth2.getAuthInstance();
          auth2.disconnect();
            window.open("login?email="+email+"&name="+name+"&img="+img+"&type=google&googleId="+id+"&status=1","_self");
        });
    });
     
}

function onFailure(error) {
    
    alert("May be Your browser is not supported this facility, please try another bo Google Chrome Browser");
}
   </script>
   <center>
       <div class="img" ><p style="font-family:sans-serif; font-size: 30px;">Login to take participate in Battles</p><img height="410px" width="380px;" style=" margin-top:-38px; margin-left: -20px;" src="photos/FAVPNG_pubg-mobile-fortnite-video-games-image_Mhjd9GS9.png"></div>
    <div  class="signimg2">
        <center><br>
            <p style="color:white;font-family:sans-serif;font-size:40px;">Login</p>
        <div style="position: relative;top:-30px;">
       <form action="login" method="get">
           <input class="in" type="email" name="email" required="required" placeholder="Email Id"><br><br>
           <input class="in" type="password" name="pass" required="required" placeholder="Password"><br><br>
           <input type="hidden" value="2" name="status">
           <input  class="signbutton" type="submit" value="Login">
           <p style="color:white;font-family:sans-serif;font-size:15px;">New Here?<a style="text-decoration:none;color:#4B7DB1" href="signup.jsp"><b> Click here</b></a> to Register</p>
           <a style="text-decoration:none;" href="forgot.jsp"><p style="color:yellow;font-family:sans-serif;font-size:15px;">Forgot Password?</p></a>
           <div style="width:250px;background-color:white;height:1px; margin-left:120px;"></div>  <br>
        <div class="g-signin2" id="gSignIn2" style="position:relative; left:50px;width:200px;"></div>
       </form>
           </div>
            
            </center>
 
    </div>
   </center>
       
</body>
</html>