package mail;
import battlesround.dao;
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

public class cng_mail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
         String email2=request.getParameter("email2");
         String email=(String)session.getAttribute("email");
         int status=dao.change_email(email,email2);
         if(status>0)
         { 
          session.setAttribute("email",email2);
         response.sendRedirect("profile.jsp");
         }else
             out.println("error");
         
        } catch (SQLException ex) {
            Logger.getLogger(cng_mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
