package administrator;

import battlesround.dao;
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
public class viewuser extends HttpServlet {
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
Connection con=dao.getConnection();
Statement stmt=con.createStatement(); 
ResultSet rs=stmt.executeQuery("select * from users where type!='admin'");

        
out.println("\n" +
"<html>\n" +
"    <head>\n" +
"        <title>\n" +
"           battlestound\n" +
"        </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    \n" +
"  <link rel=\"Stylesheet\" href=\"One.css\" type=\"text/css\">\n" +
"  <link href='https://fonts.googleapis.com/css?family=Charmonman' rel='stylesheet'>\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"    </head><body bgcolor='black'\n");  
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
       out.print("<br><br><h1 style='color:white;'>User Details</h1><table border=1 width=100% style='color:white;font-size:15px;'>");
       out.print("<form action='searchuser' method='post'>"
               + "<input type='text' name='search'>"
               + "<input type='submit' value='submit'>"
               + "</form>");
        out.println("<th>User Id</th><th>Date</th><th>Email</th><th>Password</th><th>Name</th><th>Type</th><th>Googleid</th><th>Edit</th><th>Delete</th>");
            while(rs.next()) {
   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><a style='text-decoration:none; font-size:20px;' href='edituser1?userid="+rs.getString(1)+"'>______edit______</a></td><td><a style='font-size:20px; color:red;' href='deleteuser?userid="+rs.getString(1)+"'>delete</a></td></tr>");
            }   
            out.print("</font>");
            out.print("</table></body></html>");

        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
