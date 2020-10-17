package battlesround;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class dao {
     public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/battlesround","root","root");
        }
        catch(ClassNotFoundException | SQLException e)
        {}
            return con;
        
    }
     public static int signup(usersget u) throws SQLException, FileNotFoundException
     {
      int status=0;
             Date ins=new Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("insert into users(email,name,image,type,googleId,date) values(?,?,?,?,?,?)");
      ps.setString(1,u.getemail());
      ps.setString(2,u.getname());
      ps.setString(3,u.getimg());
      ps.setString(4,u.gettype());
      ps.setString(5,u.getgoogleId());
      ps.setString(6,date);
      status=ps.executeUpdate();
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select * from users where email='"+u.getemail()+"'");
      int uid=0;
      if(rs.next())
      {
       uid=rs.getInt(1);   
      }

      ps=con.prepareStatement("insert into profile(email,name,gname,gid,house,state,city,pin,age,gender,amt,matches,kills,winnings,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1,u.getemail());
      ps.setString(2,u.getname());
      ps.setString(3,"");
      ps.setString(4,"");
      ps.setString(5,"");
      ps.setString(6,"");
      ps.setString(7,"");
      ps.setString(8,"");
      ps.setString(9,"");
      ps.setString(10,"");
      ps.setString(11,"0");
      ps.setString(12,"0");
      ps.setString(13,"0");
      ps.setString(14,"0");
      ps.setInt(15,uid);
      status=ps.executeUpdate();
      return status;
     }
     public static int cng_photo(cng_photouser c,String email) throws SQLException
     {
         int status=0;
         Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update users set image=? where email='"+email+"'");
      ps.setString(1,c.getphoto());
      status=ps.executeUpdate();
         return status;
     }
     
      public static int signup2(usersget u) throws SQLException, FileNotFoundException
     {
      int status=0;
         Date ins=new Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("insert into users(email,name,pass,image,type,googleId,date) values(?,?,?,?,?,?,?)");
      ps.setString(1,u.getemail());
      ps.setString(2,u.getname());
      ps.setString(3,u.getpass());
      ps.setString(4,u.getimg());
       ps.setString(5,u.gettype());
      ps.setString(6,u.getgoogleId());
      ps.setString(7,date);
      status=ps.executeUpdate();
       Statement stmt=con.createStatement();
       ResultSet rs=stmt.executeQuery("select * from users where email='"+u.getemail()+"'");
      int uid=0;
      if(rs.next())
      {
       uid=rs.getInt(1);   
      }
       ps=con.prepareStatement("insert into profile(email,name,gname,gid,house,state,city,pin,age,gender,amt,matches,kills,winnings,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       ps.setString(1,u.getemail());
      ps.setString(2,u.getname());
      ps.setString(3,"");
      ps.setString(4,"");
      ps.setString(5,"");
      ps.setString(6,"");
      ps.setString(7,"");
      ps.setString(8,"");
      ps.setString(9,"");
      ps.setString(10,"");
      ps.setString(11,"0");
       ps.setString(12,"0");
      ps.setString(13,"0");
      ps.setString(14,"0");
       ps.setInt(15,uid);
      status=ps.executeUpdate();
      return status;
     }
      public static int change_email(String email,String email2) throws SQLException
      {
        int status=0;
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update users set email=? where email='"+email+"'");
      ps.setString(1,email2);
      status=ps.executeUpdate();
      return status;
      }
        public static int change_pass(String pass,String email) throws SQLException
      {
        int status=0;
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update users set pass=? where email='"+email+"'");
      ps.setString(1,pass);
      status=ps.executeUpdate();
      return status;
      }
        public static int change_name(String name,String email) throws SQLException
      {
        int status=0;
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update users set name=? where email='"+email+"'");
      ps.setString(1,name);
      status=ps.executeUpdate();
       ps=con.prepareStatement("update profile set name=? where email='"+email+"'");
      ps.setString(1,name);
      status=ps.executeUpdate();
      return status;
      }
     public static int updateprofile(profile p,String email) throws SQLException
      {
        int status=0;
      Connection con=dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update profile set gname=? ,gid=?,house=?,state=?,city=?,pin=?,age=?,gender=? where email='"+email+"'");
      ps.setString(1,p.getgname());
      ps.setString(2,p.getgid());
      ps.setString(3,p.gethouse());
      ps.setString(4,p.getstate());
      ps.setString(5,p.getcity());
      ps.setString(6,p.getpin());
      ps.setString(7,p.getage());
      ps.setString(8,p.getgender());
      status=ps.executeUpdate();
      return status;
      }
     public static int remove_coins(String amount,String type,String acc,String ifsc,String email) throws SQLException
     {
         int status=0;
      Connection con=dao.getConnection();
      Statement p=con.createStatement();
          ResultSet rs=p.executeQuery("select * from profile where email='"+email+"'");
          int coins=0;
      if(rs.next())
      {
      coins=Integer.parseInt(rs.getString(12));
       }
      coins=coins-Integer.parseInt(amount);
      PreparedStatement ps=con.prepareStatement("update profile set amt=? where email='"+email+"'");
      ps.setInt(1,coins);
      status=ps.executeUpdate();
       Date ins=new Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
      PreparedStatement prs=con.prepareStatement("insert into payment(email,amount,type,acc,ifsc,date) values(?,?,?,?,?,?)");
      prs.setString(1,email);
      prs.setString(2,amount);
      prs.setString(3,type);
      prs.setString(4,acc);
      prs.setString(5,ifsc);
      prs.setString(6,date);
       status=prs.executeUpdate();
      return status;
     }
     
     public static int register_battle(register_user u,String email) throws SQLException
     {
        int status=0;
        Connection con=dao.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from profile where email='"+email+"'");
        Statement st=con.createStatement();
      ResultSet rst=st.executeQuery("select * from battles where b_id='"+u.getbid()+"'");
        if(rs.next())
        {
      PreparedStatement ps=con.prepareStatement("insert into battle_registration(email,battle_id,name,kills,winning,fee,g_name,g_id) values(?,?,?,?,?,?,?,?)");
      ps.setString(1,email);
      ps.setString(2,u.getbid());
      ps.setString(3,rs.getString(3));
      ps.setString(4,"0");
      ps.setString(5,"0");
      if(rst.next())
      {  
          ps.setString(6,rst.getString(7));
      }
      ps.setString(7,u.getgname());
      ps.setString(8,u.getgid());
      status=ps.executeUpdate();
      if(status>0)
      {
      PreparedStatement p=con.prepareStatement("update profile set gname=?,gid=?,age=?,gender=?,amt=? where email=?");
      p.setString(1,u.getgname());
      p.setString(2,u.getgid());
      p.setString(3,u.getage());
      rst=st.executeQuery("select * from battles where b_id='"+u.getbid()+"'");
      int amt=0;
      if(rst.next())
      {
       amt=Integer.parseInt(rs.getString(12))-Integer.parseInt(rst.getString(7));  
      }
      p.setString(4,u.getgender());
      p.setInt(5,amt);
      p.setString(6,email);
      status=p.executeUpdate();     
      }
      else
          return 0;
        }
        
        return status;
     }
     public static int txn(String email) throws SQLException
     {
         
         int status=0;
         Connection con=dao.getConnection();
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
         String cust_id="";
         while(rs.next())
         {
             cust_id=rs.getString(1);
         }
         String order_id="",amount="";
          Statement stm=con.createStatement();
         ResultSet rst=stm.executeQuery("select * from orders where email='"+email+"'");
         while(rst.next())
         {
             order_id=rst.getString(1);
             amount=rst.getString(3);
         }
  Date ins=new Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
         PreparedStatement ps=con.prepareStatement("insert into coins_payment(user_id,email,amount,txn,order_id,date) values(?,?,?,?,?,?)");
         ps.setString(1,cust_id);
         ps.setString(2,email);
         ps.setString(3,amount);
         ps.setString(4,"false");
         ps.setString(5,order_id);
         ps.setString(6,date);
         status=ps.executeUpdate();
         return status;
     }
     public static int txntrue(String email) throws SQLException
     {
          int status=0;
         Connection con=dao.getConnection();
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery("select * from users where email='"+email+"'");
         String cust_id="";
         while(rs.next())
         {
             cust_id=rs.getString(1);
         }
         String order_id="",amount="";
          Statement stm=con.createStatement();
         ResultSet rst=stm.executeQuery("select * from orders where email='"+email+"'");
         while(rst.next())
         {
             order_id=rst.getString(1);
             amount=rst.getString(3);
         }
         Date ins=new Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
         PreparedStatement ps=con.prepareStatement("insert into coins_payment(user_id,email,amount,txn,order_id,date) values(?,?,?,?,?,?)");
         ps.setString(1,cust_id);
         ps.setString(2,email);
         ps.setString(3,amount);
         ps.setString(4,"success");
         ps.setString(5,order_id);
         ps.setString(6,date);
         status=ps.executeUpdate();
         Statement st=con.createStatement();
         ResultSet rt=st.executeQuery("select * from profile where email='"+email+"'");
         int amt=0;
         if(rt.next())
         {
             amt=rt.getInt(12);
         }
         amt=amt+Integer.parseInt(amount);
          PreparedStatement p=con.prepareStatement("update profile set amt=? where email=?");
         p.setInt(1,amt);
         p.setString(2,email);
         status=p.executeUpdate();
         return status;
     }
     static int cancel(String id,String email) throws SQLException
     {
         int status=0;
         Connection con=dao.getConnection();
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery("select * from battle_registration where battle_id='"+id+"' and email='"+email+"' ");
         int fee=0;
         while(rs.next())
         {
            fee=rs.getInt(7);
         }
         Statement stm=con.createStatement();
         ResultSet rst=stm.executeQuery("select * from profile where email='"+email+"'");
         int cur=0;
         while(rst.next())
         {
             cur=rst.getInt(12);
         }
         fee=fee+cur;
      PreparedStatement p=con.prepareStatement("update profile set amt=? where email=?");
      p.setInt(1,fee);
      p.setString(2,email);
      p.executeUpdate();
      PreparedStatement ps=con.prepareStatement("delete from battle_registration where battle_id='"+id+"' and email='"+email+"'");
      status=ps.executeUpdate();
   
         return status;
     }
}
