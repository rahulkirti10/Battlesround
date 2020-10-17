package battlesround;
import java.sql.*;
import java.io.*;
import javax.servlet.http.HttpSession;
public class uploadimage
{  
public static int upload(String photo,String email) throws Exception, IOException, SQLException
{
PreparedStatement ps=null;
FileInputStream fs=null;
 Connection con=null;
 try 
 {
     con=dao.getConnection();
     ps=con.prepareStatement("update users set image=? where email='"+email+"'");
     ps.setString(1,photo);
     ps.executeUpdate();
return 1;  
 } 
 catch (SQLException e) 
 {
     return 0;
 }
 }
}
