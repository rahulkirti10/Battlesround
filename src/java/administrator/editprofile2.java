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
public class editprofile2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        profilepojo p=new profilepojo();
        p.setid(request.getParameter("userid"));
        p.setkills(request.getParameter("kills"));
        p.setmatch(request.getParameter("match"));
        p.setwinnings(request.getParameter("winnings"));
        p.setamt(request.getParameter("amt"));
        int status=dao.editprofile(p);
        if(status>0)
            response.sendRedirect("viewprofile");
        else 
            out.print("error");
        } catch (SQLException ex) {
            Logger.getLogger(editprofile2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
