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
public class addadmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        String gid=request.getParameter("gid");
        String name=request.getParameter("name");
        int status=dao.addadmin(email,pass,name,gid);
        if(status>0)
            response.sendRedirect("admindetails");
        else
            out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(addadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
