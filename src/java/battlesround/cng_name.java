
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
public class cng_name extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String name=request.getParameter("name");
        HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
        int status=dao.change_name(name,email);
        if(status>0)
        {
            response.sendRedirect("profile.jsp");
        }
        else
        {
            out.print("error");
        }
        } catch (SQLException ex) {
            Logger.getLogger(cng_name.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
