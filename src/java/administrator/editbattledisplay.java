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
public class editbattledisplay extends HttpServlet {
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
ResultSet rs=stmt.executeQuery("select * from battle_display where b_id='"+request.getParameter("userid")+"'");
if(rs.next())
{
out.print("<body bgcolor='black'>\n" +
"    <br><br><br>\n" +
"<center>\n" +
"    <div style=\"color:white;\">\n" +
"        <h1>Edit Battle Form</h1>\n" +
"        <form action=\"editbattledisplay2\" method=\"post\">\n"
        + "<input type='hidden' value='"+request.getParameter("userid")+"' name='userid'>" +
     
"            Enter Match: <input type=\"text\" name=\"match\" value='"+rs.getString(2)+"' placeholder=\"eg: classic\" required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"            select type: <select name=\"type\" style=\"width:80px;height:30px;\" required='required'>"
        + "<option value=''>Select</option><option value=\"Solo\">Solo</option>\n" +
"          <option value=\"Duo\">Duo</option>\n" +
"            <option value=\"Squad\">Squad</option></select><br><br>\n" +
"         select Player Type: <select name=\"p_type\" required='required' style=\"width:80px;height:30px;\"><option value=''>Select</option><option value=\"TPP\">TPP</option>\n" +
"            <option value=\"FPP\">FPP</option></select><br><br>\n" +
"        select map: <select name=\"map\" style=\"width:80px;height:30px;\" required='required'><option value=''>Select</option><option value=\"Erangle\">Erangle</option>\n" +
"            <option value=\"Miramar\">Miramar</option>\n" +
"            <option value=\"Sanhok\">Sanhok</option>\n" +
"        <option value=\"Vikendi\">Vikendi</option></select><br><br>\n" +
"        Enter Match type: <input type=\"text\" name=\"match_type\"  value='"+rs.getString(5)+"' required=\"required\" placeholder=\"eg: Regular\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter fee: <input type=\"text\" name=\"fee\" placeholder=\"eg: 10\"  value='"+rs.getString(7)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Time: <input type=\"text\" name=\"time\" placeholder=\"eg: 3:00 Pm-4:00 Pm\"  value='"+rs.getString(8)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        choose image <input type=\"text\" name=\"img\" style=\"width:300px;height:30px;\" required='required' value='"+rs.getString(9)+"'><br><br>\n" +
"        enter per kill reward <input type=\"text\" name=\"kill\" placeholder=\"eg: 10\"  value='"+rs.getString(10)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Date: <input type=\"text\" name=\"date\" placeholder=\"eg: 05/03/2020\"  value='"+rs.getString(11)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter Battle Name: <input type=\"text\" name=\"name\" placeholder=\"eg: duo clash\"  value='"+rs.getString(12)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        Enter winner reward: <input type=\"text\" name=\"winner\" placeholder=\"eg:50\"  value='"+rs.getString(13)+"' required=\"required\" style=\"width:300px;height:30px;\"><br><br>\n" +
"        <input type=\"submit\" value=\"submit\">\n" +
"        </form> \n" +
"        </div>    \n" +
"</center>\n" +
"</body>");
}
        } catch (SQLException ex) {
            Logger.getLogger(editbattledisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
