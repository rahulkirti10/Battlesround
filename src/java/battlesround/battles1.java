
package battlesround;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
public class battles1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 RequestDispatcher rd=request.getRequestDispatcher("battles.jsp?db=battle_display");
 rd.include(request, response);
            out.println("<div class=\"cancel\" id=\"cancel\">\n" +
"        <br>\n" +
"        <center> <p> <i class=\"fa fa-exclamation-triangle\" aria-hidden=\"true\"></i> Are you Sure You Want to Cancel Your registration for Battles.</p>  \n" +
"            <br><br>\n" + 
"        <form action='cancel'>   <input type='hidden' name='id' value='"+request.getParameter("id")+"' /> <input type=\"button\" onclick=\"location.href='battles.jsp'\" value=\"Cancel\" class=\"cancel-button\">\n" +
"            <input type=\"submit\" value=\"Yes\"  class=\"cancel-button\">\n </form>" +
"        </center>\n" +
"    </div>\n" +
"");           
        }
    }

   

}
