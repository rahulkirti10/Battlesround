package administrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public static int updateuser(String id,String email,String pass,String name,String type,String gid) throws SQLException
{
int status=0; 
 Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update users set email=?,pass=?,name=?,type=?,googleId=? where uid=?");
 ps.setString(1,email);
      ps.setString(2,pass);
      ps.setString(3,name);
      ps.setString(4,type);
      ps.setString(5,gid);
      ps.setString(6,id);
      status=ps.executeUpdate();
return status;
}
public static int deleteuser(String id) throws SQLException
{
int status=0; 
 Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("delete from users where uid='"+id+"'");  
      status=ps.executeUpdate();
      PreparedStatement p=con.prepareStatement("delete from profile where user_id='"+id+"'");  
      status=p.executeUpdate();
return status;
}
public static int deleteadmin(String id) throws SQLException
{
int status=0; 
 Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("delete from users where uid='"+id+"'");  
      status=ps.executeUpdate();
return status;
}
public static int addbattles(batllespojo b) throws SQLException
{
    int status=0;
    Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("insert into battles(matches,type,player_type,match_type,map_type,fees,time,image,kil,date,b_name,winner) values(?,?,?,?,?,?,?,?,?,?,?,?)");  
     ps.setString(1,b.getmatch());
      ps.setString(2,b.gettype());
       ps.setString(3,b.getp_type());
        ps.setString(4,b.getmatch_type());
         ps.setString(5,b.getmap());
          ps.setString(6,b.getfee());
           ps.setString(7,b.gettime());
            ps.setString(8,b.getimg());
             ps.setString(9,b.getkill());
              ps.setString(10,b.getdate());
               ps.setString(11,b.getname());
                ps.setString(12,b.getwinner());
      status=ps.executeUpdate();
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select * from battles");
      String id="";
      while(rs.next())
      {
          id=rs.getString(1);
      }
      ps=con.prepareStatement("insert into battle_display(b_id,matches,type,player_type,match_type,map_type,fees,time,image,kil,date,b_name,winner) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");  
     ps.setString(1,id);
      ps.setString(2,b.getmatch());
      ps.setString(3,b.gettype());
       ps.setString(4,b.getp_type());
        ps.setString(5,b.getmatch_type());
         ps.setString(6,b.getmap());
          ps.setString(7,b.getfee());
           ps.setString(8,b.gettime());
            ps.setString(9,b.getimg());
             ps.setString(10,b.getkill());
              ps.setString(11,b.getdate());
               ps.setString(12,b.getname());
                ps.setString(13,b.getwinner());
      status=ps.executeUpdate();
    return status;
}

    static int editbattles(batllespojo b,String id) throws SQLException {
       int status=0;
 Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update battles set matches=?,type=?,player_type=?,match_type=?,map_type=?,fees=?,time=?,image=?,kil=?,date=?,b_name=?,winner=? where b_id=?");
  ps.setString(1,b.getmatch());
      ps.setString(2,b.gettype());
       ps.setString(3,b.getp_type());
        ps.setString(4,b.getmatch_type());
         ps.setString(5,b.getmap());
          ps.setString(6,b.getfee());
           ps.setString(7,b.gettime());
            ps.setString(8,b.getimg());
             ps.setString(9,b.getkill());
              ps.setString(10,b.getdate());
               ps.setString(11,b.getname());
                ps.setString(12,b.getwinner());
                 ps.setString(13,id);
      status=ps.executeUpdate();  
      return status;
    }
    static int editbattledisplay(batllespojo b,String id) throws SQLException {
       int status=0;
 Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update battle_display set matches=?,type=?,player_type=?,match_type=?,map_type=?,fees=?,time=?,image=?,kil=?,date=?,b_name=?,winner=? where b_id=?");
  ps.setString(1,b.getmatch());
      ps.setString(2,b.gettype());
       ps.setString(3,b.getp_type());
        ps.setString(4,b.getmatch_type());
         ps.setString(5,b.getmap());
          ps.setString(6,b.getfee());
           ps.setString(7,b.gettime());
            ps.setString(8,b.getimg());
             ps.setString(9,b.getkill());
              ps.setString(10,b.getdate());
               ps.setString(11,b.getname());
                ps.setString(12,b.getwinner());
                 ps.setString(13,id);
      status=ps.executeUpdate();  
      return status;
    }
public static int editprofile(profilepojo b) throws SQLException 
     {
       int status=0;
 Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("update profile set amt=?,matches=?,kills=?,winnings=? where p_id=?");
  ps.setString(1,b.getamt());
      ps.setString(2,b.getmatch());
       ps.setString(3,b.getkills());
        ps.setString(4,b.getwinnings());
      ps.setString(5,b.getid());
      status=ps.executeUpdate();  
      return status;
    }
static int addadmin(String email,String pass,String name,String gid) throws SQLException
{
    int status=0;
     java.util.Date ins=new java.util.Date();
            DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
            String date=d.format(ins);
      Connection con=battlesround.dao.getConnection();
      PreparedStatement ps=con.prepareStatement("insert into users(email,name,pass,type,googleId,date) values(?,?,?,?,?,?)");
      ps.setString(1,email);
      ps.setString(2,name);
      ps.setString(3,pass);
      ps.setString(4,"admin");
      ps.setString(5,gid);
      ps.setString(6,date);
      status=ps.executeUpdate();
    return status;
}

    static int deleterequest(String id) throws SQLException {
  int status=0; 
 Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("delete from payment where pay_id='"+id+"'");  
      status=ps.executeUpdate();
return status;
    }
    static int deletetransaction(String id) throws SQLException {
  int status=0; 
 Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("delete from coins_payment where c_id='"+id+"'");  
      status=ps.executeUpdate();
return status;
    }

    static int editregistration(String id, String kills, String winning,String email,String rank) throws SQLException 
    {
       int status=0;
       Connection con=dao.getConnection();
       PreparedStatement ps=con.prepareStatement("update battle_registration set kills=?,winning=?,rank=? where reg_id=?");
       ps.setString(1,kills);
       ps.setString(2,winning);
       ps.setString(3,rank);
        ps.setString(4,id);
       status=ps.executeUpdate();
       Statement stmt=con.createStatement();
       ResultSet rs=stmt.executeQuery("select * from profile where email='"+email+"'");
       int kill=0,win=0,match=0;
       if(rs.next())
       {
          kill=rs.getInt(14);
          win=rs.getInt(15);
          match=rs.getInt(13);
       }
       kill=kill+Integer.parseInt(kills);
       win=win+Integer.parseInt(winning);
       match=match+1;
      PreparedStatement pst=con.prepareStatement("update profile set matches=?,kills=?,winnings=? where email=?");
      pst.setInt(1,match);
      pst.setInt(2,kill);
      pst.setInt(3,win);
      pst.setString(4,email);
      status=pst.executeUpdate();
      
      return status;
    }
}
