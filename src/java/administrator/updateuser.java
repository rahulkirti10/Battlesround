package administrator;
import administrator.dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class updateuser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { 
            String id=request.getParameter("userid");
            String email=request.getParameter("email");
            String pass=request.getParameter("pass");
            String name=request.getParameter("name");
            String type=request.getParameter("type");
            String gid=request.getParameter("gid");
            
            
            int status=dao.updateuser(id,email,pass,name,type,gid);
            if(status>0)
                response.sendRedirect("viewuser");
            else
            {out.print("error");}
}       catch (SQLException ex) {
            Logger.getLogger(updateuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
