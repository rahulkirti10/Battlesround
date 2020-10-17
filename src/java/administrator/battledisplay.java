package administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class battledisplay extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
                request.getRequestDispatcher("adminheader.jsp").include(request, response);
             HttpSession session=request.getSession();
           if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
Connection con=battlesround.dao.getConnection();
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from battle_display order by b_id desc");
        
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
        out.println("<br><br><h1 style='color:white;'>Battles Details</h1>"
        + "<form action='searchbattles' method='post'>"
        + "<h2 style='color:white;'>Battle Id:</h2><select name='search' style='width:80px;height:30px;' required='required'> ");
out.print("<option value=''>Select</option>");
while(rs.next())
{
out.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
}
 rs=stm.executeQuery("select * from battle_display order by b_id desc");
out.print("</select><input type='submit' value='search'>"
        + "</form>");
       out.print("<table border=1 width=100% style='color:white;font-size:15px;'>");
        out.println("<th>Battle Id</th><th>Match</th><th>type</th><th>Player type</th><th>Match type</th><th>Map</th><th>Fee</th><th>time</th><th>image</th><th>rewards on kills</th><th>Date</th><th>Battle name</th><th>winner</th><th>Complete</th><th>Edit</th><th>Delete</th>");
            while(rs.next()) {
   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td><center><form action='updatecomplete' method='post'><input type='hidden' name='id' value='"+rs.getString(1)+"'> <input type='submit' value='"+rs.getString(14)+"' style='background-color:green;border:none;width:100px;height:30px;'></form></center></td><td><a style='text-decoration:none; font-size:20px;' href='editbattledisplay?userid="+rs.getString(1)+"'>______edit______</a></td><td><a style='font-size:20px; color:red;' href='deletebattledisplay?userid="+rs.getString(1)+"'>delete</a></td></tr>");
            }   
            out.print("</font>");
            out.print("</table></body></html>");

        } catch (SQLException ex) {
            Logger.getLogger(battledisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
