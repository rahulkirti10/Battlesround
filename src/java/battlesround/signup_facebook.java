package battlesround;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class signup_facebook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String access_token=(String)request.getParameter("access_token");
            Prodile_Modal obj_Profile_Modal=new Prodile_Modal();
            Profile_Bean obj_Profile_Bean= obj_Profile_Modal.call_me(access_token);
            usersget u=new usersget();
            String email=obj_Profile_Bean.getEmail();
            String name=obj_Profile_Bean.getUser_name();
            String img=obj_Profile_Bean.getProfile_picture();
            u.setemail(email);
            u.setname(name);
            u.setimg(img);
            int status=dao.signup(u);
            if(status>0)
            response.sendRedirect("home.jsp");

        } catch (Exception ex) {
            Logger.getLogger(signup_facebook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
