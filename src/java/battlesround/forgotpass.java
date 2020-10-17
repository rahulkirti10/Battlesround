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
public class forgotpass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       String pass=request.getParameter("pass");
       String email=request.getParameter("email");
        int status=dao.change_pass(pass,email);
        if(status>0)
        {
            out.print("<script>"
                    + "alert('Sucessfully change Password');"
                    + "window.open('login.jsp')"
                    + "</script>");        }
        else
        {
            out.print("error");
        }
        } catch (SQLException ex) {
            Logger.getLogger(forgotpass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
