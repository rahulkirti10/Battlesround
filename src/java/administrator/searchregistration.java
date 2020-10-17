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
public class searchregistration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("adminheader.jsp").include(request, response);
Connection con=dao.getConnection();
Statement stmt=con.createStatement();

 String search=request.getParameter("search");  
 Statement stm=con.createStatement();
ResultSet rst=stm.executeQuery("select * from battles");
ResultSet rs=stmt.executeQuery("select * from battle_registration where battle_id='"+search+"'");      
out.println("\n" +
"<html>\n" +
"    <head>\n" +
"        <title>\n" +
"           BOOKS\n" +
"        </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"    </head><body bgcolor='black'>");  
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
out.println("<br><br><h1 style='color:white;'>Battles Registration Details</h1>"
        + "<form action='searchregistration' method='post'>"
        + "<h2 style='color:white;'>Battle Id:</h2><select name='search' style='width:80px;height:30px;' required='required'> ");
out.print("<option value=''>Select</option>");
while(rst.next())
{
out.print("<option value="+rst.getString(1)+">"+rst.getString(1)+"</option>");
}
out.print("</select><input type='submit' value='search'>"
        + "</form>");
       out.print("<table border=1 width=100% style='color:white;font-size:20px;'>");
        out.println("<th>Registraion Id</th><th>Email</th><th>Battle Id</th><th>Name</th><th>Kills</th><th>Winning</th><th>Fee</th><th>Edit</th><th>Delete</th>");
            while(rs.next()) {
   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><a style='text-decoration:none; font-size:20px;' href='edituser1?userid="+rs.getString(1)+"'>______edit______</a></td><td><a style='font-size:20px; color:red;' href='deleteuser?userid="+rs.getString(1)+"'>delete</a></td></tr>");
            }   
            out.print("</font>");
            out.print("</table></body></html>");

        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
