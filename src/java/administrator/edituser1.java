package administrator;
import administrator.dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class edituser1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
  request.getRequestDispatcher("adminheader.jsp").include(request, response);
             HttpSession session=request.getSession();
           if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
String userid=request.getParameter("userid");
Connection con=dao.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from users where uid='"+userid+"'");
out.println("\n" +
"<html>\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    \n" +
"    </head><body bgcolor='black'>\n");        
out.println("<br><br><h1 style='color:white;'>User Details</h1<br>");
out.println("<form action='updateuser' method='post'><table border=1 width=100% style='color:white; border-color:#335252; border-size:20px;'> "); 
        out.println("<th>User Id</th><th>Email</th><th>Password</th><th>Name</th><th>Type</th><th>Googleid</th><th>Update</th>");
            while(rs.next()) {
   out.println("<tr><td><input type='text' name='userid' value='"+rs.getString(1)+"'/></td><td><input type='text' name='email' value='"+rs.getString(2)+"'/></td><td><input name='pass' type='text' value='"+rs.getString(3)+"'/></td><td><input type='text' name='name' value='"+rs.getString(4)+"'/></td><td><input type='text' name='type' value='"+rs.getString(6)+"'/></td><td><input type='text' name='gid' value='"+rs.getString(7)+"'/></td><td><button type='submit' >update</button></td></tr>");
            }   
            out.print("</table></form>");
                      } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
