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
public class editregistration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          String id=request.getParameter("userid");
           request.getRequestDispatcher("adminheader.jsp").include(request, response);
          HttpSession session=request.getSession();
           if(session.getAttribute("email")==null)
    response.sendRedirect("login.jsp");
     response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
     Connection con=dao.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from battle_registration where reg_id='"+id+"'");
if(rs.next())
{
out.print("<body bgcolor='black'>\n" +
"    <br><br><br>\n" +
"<center>\n" +
"    <div style=\"color:white;\">\n" +
"        <h1>Edit Battle Form</h1>\n" +
        
"        <form action=\"editregistration2\" method=\"post\">\n"+
"        <h1>Email: "+rs.getString(2)+"</h1>\n" +
"        <h1>Game Name: "+rs.getString(8)+"</h1>\n" +
        "        <h1>Game Id: "+rs.getString(9)+"</h1>\n" +
        "<input type='hidden' value='"+request.getParameter("userid")+"' name='userid'>" +
     "<input type='hidden' value='"+rs.getString(2)+"' name='email'>" +
"            Enter Kills: <input type=\"text\" name=\"kills\" value='"+rs.getString(5)+"' placeholder=\"eg: classic\" required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Winning : <input type=\"text\" name=\"winning\"  value='"+rs.getString(6)+"' required=\"required\" placeholder=\"eg: Regular\" style=\"width:300px;height:30px;\"><br><br>\n" +
        "        Enter Rank : <input type=\"text\" name=\"rank\"  value='"+rs.getString(10)+"' required=\"required\" placeholder=\"eg: Regular\" style=\"width:300px;height:30px;\"><br><br>\n" +

"      <input type=\"submit\" value=\"submit\">\n" +
"        </form> \n" +
"        </div>    \n" +
"</center>\n" +
"</body>");
        }
    }   catch (SQLException ex) {
            Logger.getLogger(editregistration.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
