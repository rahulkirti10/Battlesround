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
import javax.servlet.http.HttpSession;
public class coinsadded extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    String allowed=request.getParameter("retryAllowed");
    HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
        if(allowed==null)
    {
        int status=dao.txntrue(email);
        if(status>0)
        response.sendRedirect("coinsadded.jsp?status=2&error=success");
    }
else
    if(allowed.equals("false"))
    {
        int status=dao.txn(email);
        if(status>0)
        response.sendRedirect("coinsadded.jsp?status=1&error="+request.getParameter("errorMessage"));
    }
    
        } catch (SQLException ex) {
            Logger.getLogger(coinsadded.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
