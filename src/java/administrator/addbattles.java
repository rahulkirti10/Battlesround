package administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class addbattles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     batllespojo b=new batllespojo();
     b.setmatch(request.getParameter("match"));
     b.settype(request.getParameter("type"));
     b.setp_type(request.getParameter("p_type"));
     b.setmap(request.getParameter("map"));
     b.setmatch_type(request.getParameter("match_type"));
     b.setfee(request.getParameter("fee"));
     b.settime(request.getParameter("time"));
     b.setimg(request.getParameter("img"));
     b.setkill(request.getParameter("kill"));
     b.setdate(request.getParameter("date"));
     b.setname(request.getParameter("name"));
     b.setwinner(request.getParameter("winner"));
     int status=dao.addbattles(b);
     if(status>0)
         response.sendRedirect("viewbattles");
     else
         out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(addbattles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
