
package battlesround;

import static battlesround.dao.cancel;
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
public class cancel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session=request.getSession();
          String email=(String)session.getAttribute("email");
          String id=request.getParameter("id");
          out.print(id);
           int status=cancel(id,email);
           if(status>0)
           {
               response.sendRedirect("battles.jsp?db=battle_display");
                   
                   }
           else
               out.print("error");
               
        } catch (SQLException ex) {
            Logger.getLogger(cancel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
