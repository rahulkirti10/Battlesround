package battlesround;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
 
class NewClass {
FileOutputStream image;
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt= null;
ResultSet res = null;
StringBuffer query=null;
String filename = "C:\\sams1\\test.JPG";
String driverName = "com.mysql.jdbc.Driver"; 
String url = "jdbc:mysql://localhost:3306/battlesround";
String userName = "root";
String password = "root";
int i=0;
 
public NewClass(){
try{
    
Class.forName(driverName);
con = DriverManager.getConnection(url,userName,password);
stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM uploadimages Where img_id=1");
while (rs.next()) {
     
Blob test=rs.getBlob(3);
int blobLength = (int) test.length();
byte[] blobAsBytes = test.getBytes(1, blobLength);
System.out.println("Length"+blobLength);
 
System.out.println("testlen"+blobAsBytes.length);
 
 
 
BufferedImage image = ImageIO.read( new ByteArrayInputStream( blobAsBytes ) );
 
 
ImageIO.write(image, "JPEG", new File("C://Users//rahul//Documents//NetBeansProjects//quickstart/image1.png"));
   //ImageIO.write(image, "JPEG", new File("C:\\sams1\\image.JPG"));
   //   ImageIO.write(image, "PNG", new File("C:\\sams1\\image.PNG"));
   //   ImageIO.write(image, "BMP", new File("C:\\sams1\\image.BMP"));
  //    ImageIO.write(image, "TIF", new File("C:\\sams1\\image.TIF"));
System.out.println("row"+i);
 
 
i++;
 
}
}
catch(Exception e){
System.out.println("Exception :"+e);
}
finally{
try{
stmt.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
}
public static void main(String args[]) throws IOException{
NewClass blob = new NewClass();
}
}
