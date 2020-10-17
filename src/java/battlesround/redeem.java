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
import mail.mail;
import mail.mailowners;
public class redeem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
   HttpSession session=request.getSession();
   String email=(String)session.getAttribute("email");
   int status=0;
            String amount=request.getParameter("amount");
            String type=request.getParameter("amt");
            String acc=request.getParameter("acc");
            String ifsc=request.getParameter("ifsc");
            status=mailowners.sendmail(amount,type,acc,ifsc,email);
            if(status>0)
            {
                int stat=dao.remove_coins(amount,type,acc,ifsc,email);
                if(stat>0)
                {
                    response.sendRedirect("profile.jsp");
                }
                else
                    out.print("error");
                }
            else
                out.print("error");
            } catch (SQLException ex) {
            Logger.getLogger(redeem.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
