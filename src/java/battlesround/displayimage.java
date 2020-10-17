package battlesround;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class displayimage extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 Blob image = null;

Connection con = null;

byte[ ] imgData = null ;

Statement stmt = null;

ResultSet rs = null;

try {

Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battlesround","root","root");

stmt = con.createStatement();

rs = stmt.executeQuery("select * from uploadimages where img_id='1'");

if(rs.next()) {

image = rs.getBlob(3);

imgData = image.getBytes(1,(int)image.length());
} else {

out.println("Display Blob Example");

out.println("image not found for given id>");

return;

}
response.setContentType("image/gif");

OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();

o.close();

} catch (Exception e) {

out.println("Unable To Display image");

out.println("Image Display Error=" + e.getMessage());

return;

} finally {

try {

rs.close();

stmt.close();

con.close();

} catch (SQLException e) {

e.printStackTrace();

}

}}
       }
   } 
