package administrator;
import battlesround.dao;
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
public class viewprofile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("adminheader.jsp").include(request, response);
             HttpSession session=request.getSession();
           if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
Connection con=dao.getConnection();
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from profile");
        
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
out.println("<br><br><h1 style='color:white;'>Profile details</h1>");
       out.print("<table border=1 width=100% style='color:white;font-size:15px;'>");
        out.println("<th>P. Id</th><th>User Id</th><th>email</th><th>name</th><th>game name</th><th>game id</th><th>house</th><th>state</th><th>city</th><th>pin</th><th>age</th><th>gender</th><th>amount</th><th>matches</th><th>kills</th><th>winnings</th><th>Edit</th>");
        out.print("<form action='searchprofile' method='post'>"
               + "<input type='text' name='search'>"
               + "<input type='submit' value='submit'>"
               + "</form>");   
        while(rs.next()) {
   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(16)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td>"+rs.getString(14)+"</td><td>"+rs.getString(15)+"</td><td><a style='text-decoration:none; font-size:20px;' href='editprofile?userid="+rs.getString(1)+"'>______edit______</a></td></tr>");
            }   
            out.print("</font>");
            out.print("</table></body></html>");

        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
