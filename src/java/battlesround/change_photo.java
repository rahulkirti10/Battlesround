
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
public class change_photo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
            String email=(String)session.getAttribute("email");
            String photo=request.getParameter("photo");
            cng_photouser c=new cng_photouser();
            c.setphoto(photo);
            String stat=request.getParameter("status");
            if(stat.equals("2"))
            {

            int status=dao.cng_photo(c,email);
            if(status>0)
                response.sendRedirect("profile.jsp");
            else
            {
                out.print("error");
            }
            }
            else if(stat.equals("1"))
            {
   
                String upload=request.getParameter("photo");
             int status=uploadimage.upload(upload,email);
             if(status==1)
               response.sendRedirect("profile.jsp");  
             else
            {
                out.print("error");
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(change_photo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(change_photo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
