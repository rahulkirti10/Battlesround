package administrator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class adminverify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 String email=request.getParameter("email");
out.print("<form action='verifycomplete' method='post'>"
        + "Enter your Google Id:<input type='text' name='gid'>"
        + "<input type='hidden' name='email' value="+request.getParameter("email")+">"
        + "<input type='submit' value='submit'>"
        + "</form>");
        }
    }
}



