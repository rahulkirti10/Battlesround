 
package battlesround;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
public class deleteaccount extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
  HttpSession session=request.getSession();
  String email=(String)session.getAttribute("email");
  Connection con=dao.getConnection();
  PreparedStatement ps=con.prepareStatement("delete from users where email='"+email+"'");
  ps.executeUpdate();
  ps=con.prepareStatement("delete from profile where email='"+email+"'");
  int status=ps.executeUpdate();
  if(status>0)
  {
      session.removeAttribute("email");
      response.sendRedirect("profile.jsp");
  }
  else
  {
      out.println("error");
  }
        } catch (SQLException ex) {
            Logger.getLogger(deleteaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
