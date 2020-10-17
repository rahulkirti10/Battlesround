package battlesround;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class battle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
String bid=request.getParameter("bid");
String gname=request.getParameter("gname");
String gid=request.getParameter("gid");   
String age=request.getParameter("age");
HttpSession session=request.getSession();
String email=(String)session.getAttribute("email");
String gender=request.getParameter("gender");
register_user u=new register_user();
u.setage(age);
u.setbid(bid);
u.setgid(gid);
u.setgname(gname);
u.setgender(gender);
int status=dao.register_battle(u,email);
if(status>0)
{
    response.sendRedirect("battles.jsp?db="+request.getParameter("db")+"");
}
else
    out.print("error");

        } catch (SQLException ex) {
            Logger.getLogger(battle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
