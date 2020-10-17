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
public class editregistration2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       String id=request.getParameter("userid");
       String kills=request.getParameter("kills");
       String winning=request.getParameter("winning");
       String rank=request.getParameter("rank");
       String email=request.getParameter("email");
       int status=dao.editregistration(id,kills,winning,email,rank);
       if(status>0)
           response.sendRedirect("registration");
       else
           out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(editregistration2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
