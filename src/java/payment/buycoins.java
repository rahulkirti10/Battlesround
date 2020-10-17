package payment;
import battlesround.dao;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class buycoins extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
        Connection con=dao.getConnection();
        Statement st=con.createStatement();
        String cust_id="";
        ResultSet rs=st.executeQuery("select * from users where email='"+email+"'");
        if(rs.next())
        {   
        PreparedStatement ps=con.prepareStatement("insert into orders(email,amount) values(?,?)");
        ps.setString(1,email);
        ps.setString(2,request.getParameter("amount"));
        ps.executeUpdate();
        cust_id=rs.getString(1);
        }
       Statement stmt=con.createStatement();
        ResultSet rst=stmt.executeQuery("select * from orders where email='"+email+"'"); 
        String order_id="";
        while(rst.next())
        {
            order_id=rst.getString(1);
        }
        
    out.print("<form action='coinsredirect' method='post' name='f1'>"
                   +"<input type='hidden' name='ORDER_ID' value='"+order_id+"'>"
                + "<input type='hidden' name='CUST_ID' value='"+cust_id+"'>"
                   + "<input type='hidden' name='TXN_AMOUNT' value='"+request.getParameter("amount")+"'>"
                    +"<input type='text' name=\"INDUSTRY_TYPE_ID\"  value=\"Retail\">"
                  + "<input type='text'	 name=\"CHANNEL_ID\" value=\"WEB\">"   
                                      
                                + "</form>");
    out.print("<script>"
            + "document.f1.submit();"
            + "</script>");
        
        } catch (Exception ex) {
         Logger.getLogger(buycoins.class.getName()).log(Level.SEVERE, null, ex);
     }
    } 
}
