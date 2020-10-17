package battlesround;
import java.text.SimpleDateFormat;
import java.util.*;
public class NewClass1 {
    public static void main(String args[])
    {
        Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yyyy");
String strDate = ft.format(dNow);  
 SimpleDateFormat ftt = 
      new SimpleDateFormat ("hh:mm");
 String d=ftt.format(dNow);
      System.out.println( strDate);
       System.out.println(d);
       String time="3:22 Pm-4:35 Pm";
       String tt1=String.valueOf(time.charAt(10))+String.valueOf(time.charAt(11));
       int t1=Integer.parseInt(tt1);
       System.out.println(t1);
      
    }

}
