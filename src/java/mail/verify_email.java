package mail;
import battlesround.dao;
import java.io.IOException;
import java.lang.Math; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static mail.mail.sendmail;
public class verify_email extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            HttpSession session=request.getSession();
            Connection con=dao.getConnection();
        Statement stmt=con.createStatement();
            String email=request.getParameter("email");
             ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
             if(rs.next())
             {
                 out.print("Email Already Register");
             }
            else
             {
            int rand=0;String otp="";
            for(int i=1;i<=6;i++)
            { rand =(int)(Math.random()*9);
            otp+=rand;
            }
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");  
            try {
                sendmail(email,otp);
                session.setAttribute("pass",pass);
                session.setAttribute("otp",otp);
        out.print("<form action='verify.jsp' method='post' name='f1'>"
                + "<input type='hidden' name='email' value='"+email+"'>"
                        + "<input type='hidden' name='pass' value='"+request.getParameter("pass")+"'>"
                                + "<input type='hidden' name='name' value='"+name+"'>"
                                        + "<input type='hidden' name='status' value='"+2+"'>"
+ "<input type='hidden' name='otp' value='"+otp+"'>");
        out.println("<script type='text/javascript'>");
                out.println("document.f1.submit()</script>");
                    out.println("</form>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            out.print(ex);
        }
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(verify_email.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            int rand=0;String otp="";
            HttpSession session=request.getSession();
            for(int i=1;i<=6;i++)
            { rand =(int)(Math.random()*9);
            otp+=rand;
            }
        String email=request.getParameter("email");
            try {
                int status=sendmail(email,otp);
                session.setAttribute("otp",otp);
              out.print("<form action='verify.jsp' method='post' name='f1'>"
                + "<input type='hidden' name='email' value='"+email+"'>"
                        + "<input type='hidden' name='pass' value='"+request.getParameter("pass")+"'>"
                                + "<input type='hidden' name='name' value='"+request.getParameter("name")+"'>"
                                         + "<input type='hidden' name='status' value='"+1+"'>"
+ "<input type='hidden' name='otp' value='"+otp+"'>");
        out.println("<script type='text/javascript'>");
                out.println("document.f1.submit()</script>");
                    out.println("</form>");
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print(ex);
        } 
            
        }
}
}