package battlesround;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class signup extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session=request.getSession();
            usersget u=new usersget();
        Connection con=dao.getConnection();
        Statement stmt=con.createStatement();
      String email=request.getParameter("email");
            String type=request.getParameter("type");
            String googleId=request.getParameter("googleId");
           
            ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
             if(rs.next())
             {
                 if(rs.getString(2).equals(email)&&rs.getString(6).equals(type)&&rs.getString(7).equals(googleId))
                 {
                     session.setAttribute("email",rs.getString(2));
                     response.sendRedirect("home.jsp");
                 }
                 else
                 {
                     out.print("<script>alert('Invalid SignIn');</script>");
                 }
             }
             else
             {
            String name=request.getParameter("name");
            String img=request.getParameter("img");
            u.setemail(email);
            u.setname(name);
            u.setimg(img);
            u.settype(type);
            u.setgoogleId(googleId);
            int status=dao.signup(u);
            if(status>0)
            {
                session.setAttribute("email",email);
                response.sendRedirect("home.jsp");
            }
             }
                 
        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session=request.getSession();
            usersget u=new usersget();
            Connection con=dao.getConnection();
        Statement stmt=con.createStatement();
            String email=request.getParameter("email"); 
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            u.setemail(email);
            u.setname(name);
            u.setpass(pass);
            u.settype("Battlesround user");
            u.setgoogleId("0");
            u.setimg("photos/profile/kissclipart-icon-clipart-computer-icons-online-chat-avatar-a7afb5a6b53123e5.png");
            int status=dao.signup2(u);
            if(status>0)
            {            
    session.removeAttribute("otp");
    session.removeAttribute("pass");
    session.setAttribute("email",email);
                response.sendRedirect("home.jsp");
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
