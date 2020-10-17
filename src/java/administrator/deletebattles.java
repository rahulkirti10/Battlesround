package administrator;
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
public class deletebattles extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("delete from battles where b_id='"+request.getParameter("userid")+"'");
  int status=ps.executeUpdate();
           if(status>0)
               response.sendRedirect("viewbattles");
           else
               out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(deletebattles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
