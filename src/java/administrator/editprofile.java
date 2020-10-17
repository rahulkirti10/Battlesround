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
public class editprofile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
request.getRequestDispatcher("adminheader.jsp").include(request, response);
             HttpSession session=request.getSession();
           if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
     response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
     Connection con=dao.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from profile where p_id='"+request.getParameter("userid")+"'");
if(rs.next())
{
out.print("<body bgcolor='black'>\n" +
"    <br><br><br>\n" +
"<center>\n" +
"    <div style=\"color:white;\">\n" +
"        <h1>Edit Battle Form</h1>\n" +
"        <form action=\"editprofile2\" method=\"post\">\n"
        + "<input type='hidden' value='"+request.getParameter("userid")+"' name='userid'>"
                + "<h2>Email Id: "+rs.getString(2)+"</h2><h2>Name Id:"+rs.getString(3)+"</h2>"
                        + "<h2>Game Name:"+rs.getString(4)+"</h2>"
                                + "<h2>Game Id:"+rs.getString(5)+"</h2>" +
"            Enter Amount: <input type=\"text\" name=\"amt\" value='"+rs.getString(12)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Matches: <input type=\"text\" name=\"match\"  value='"+rs.getString(13)+"' required=\"required\" placeholder=\"eg: Regular\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Kills: <input type=\"text\" name=\"kills\"   value='"+rs.getString(14)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Winnings: <input type=\"text\" name=\"winnings\"   value='"+rs.getString(15)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        <input type=\"submit\" value=\"submit\">\n" +
"        </form> \n" +
"        </div>    \n" +
"</center>\n" +
"</body>");
        
        }
    }   catch (SQLException ex) {
            Logger.getLogger(editprofile.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
