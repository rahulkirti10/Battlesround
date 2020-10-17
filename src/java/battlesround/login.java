package battlesround;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
Connection con=dao.getConnection();
Statement stmt=con.createStatement();
String email=request.getParameter("email");
ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
            String type=request.getParameter("type");
            String googleId=request.getParameter("googleId");
if(request.getParameter("status").equals("1"))
{
    if(rs.next())
{
    if(rs.getString(2).equals(email)&&rs.getString(6).equals(type)&&rs.getString(7).equals(googleId))
    {session.setAttribute("email",rs.getString(2)); 
        response.sendRedirect("home.jsp");}
    else
                 {
                     out.print("<script>alert('Invalid email');</script>");
                        
                  response.sendRedirect("login.jsp");
                 }
}
    else
    {
                  out.print("<script>alert('Please signup first');</script>");   
                 
    }
}
else
{
    ResultSet rst=stmt.executeQuery("select * from users where email='"+email+"' and type='Battlesround user'");
if(rst.next())
{
    if(rst.getString(2).equals(request.getParameter("email"))&&rst.getString(3).equals(request.getParameter("pass")))
    { session.setAttribute("email",rst.getString(2));
      response.sendRedirect("home.jsp");}
    else
                 {
                     out.print("<script>alert('Invalid email or password');</script>");
                        
                
                 }
}
else 
{
Statement st=con.createStatement();   
ResultSet rt=st.executeQuery("select * from users where email='"+email+"' and type='admin'");
if(rt.next())
{
    if(rt.getString(2).equals(request.getParameter("email"))&&rt.getString(3).equals(request.getParameter("pass")))
    { 
      response.sendRedirect("adminverify?email="+request.getParameter("email"));
    }
    else
                 {
                     out.print("<script>alert('Invalid email or password');</script>");
                        
                
                 }
}
}
}
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
