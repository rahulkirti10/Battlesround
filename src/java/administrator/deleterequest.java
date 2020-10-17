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
public class deleterequest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id=request.getParameter("userid");
            int status=dao.deleterequest(id);
            if(status>0)
                response.sendRedirect("viewrequest");
            else
                out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(deleterequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
