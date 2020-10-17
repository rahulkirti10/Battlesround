
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

public class update_profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       profile p=new profile();
       HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
       p.setage(request.getParameter("age"));
       p.sethouse(request.getParameter("house"));
       p.setgender(request.getParameter("gender"));
       p.setcity(request.getParameter("city"));
       p.setgname(request.getParameter("gname"));
       p.setgid(request.getParameter("gid"));
       p.setstate(request.getParameter("state"));
       p.setpin(request.getParameter("pin"));
       int status=dao.updateprofile(p,email);
       if(status>0)
           response.sendRedirect("profile.jsp");
       else
           out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(update_profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
