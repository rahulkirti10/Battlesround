package administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class verifycomplete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email=request.getParameter("email");
            String gid=request.getParameter("gid");
            Connection con=dao.getConnection();
            Statement stmt=con.createStatement();
            HttpSession session=request.getSession();
            ResultSet rs=stmt.executeQuery("select * from users where googleId='"+gid+"'");
            if(rs.next())
            {
                 session.setAttribute("email",email);
                response.sendRedirect("adminpannel.jsp");
            }
            else
            {
                out.print("<script>alert('invalid google id');"
                        + "window.history.go(-1);</script>");
                
            }
            } catch (SQLException ex) {
            Logger.getLogger(verifycomplete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
