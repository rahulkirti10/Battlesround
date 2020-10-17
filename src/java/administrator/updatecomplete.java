package administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class updatecomplete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          String id=request.getParameter("id");
          Connection con=dao.getConnection();
          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from battle_display where b_id='"+id+"'");
          int status=0;
          while(rs.next())
          {
              if(rs.getString(14).equals("NO"))
              {
          PreparedStatement ps=con.prepareStatement("update battle_display set complete=? where b_id=?");
          ps.setString(1,"YES");
          ps.setString(2,id);
         status= ps.executeUpdate();
              }
              else
              {
                  PreparedStatement ps=con.prepareStatement("update battle_display set complete=? where b_id=?");
          ps.setString(1,"NO");
          ps.setString(2,id);
         status= ps.executeUpdate();
              }
                  
          
          }
          if(status>0)
              response.sendRedirect("battledisplay");
          else
              out.print("error");

        } catch (SQLException ex) {
            Logger.getLogger(updatecomplete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
