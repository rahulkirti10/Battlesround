package mail;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
public class mailowners {  
    public static Message preparemessage(Session session,String user,String pass,String amount,String type,String acc,String ifsc,String email ) throws AddressException, MessagingException
    {
        
        Message m=new MimeMessage(session);
        m.setFrom(new InternetAddress(user));
        m.setRecipient(Message.RecipientType.TO, new InternetAddress(pass));
        m.setSubject("Redeem request");
        String htmlCode="<h1>You have new redeem request:</h1>"
                + "<br>Amount:"+amount+""
                + "<br>type: "+type+""
                + "<br>Account number: "+acc+""
                + "<br>ifsc code: "+ifsc+""
                + "<br>email: "+email;
        m.setContent(htmlCode,"text/html");
        return m;
    }   
 public static int sendmail(String amount,String type,String acc,String ifsc,String email) {  
  
  String host="smtp.gmail.com";  
  final String user="rahulkirti10@gmail.com"; 
  final String password="ioppoiiop";  
   Properties props = new Properties();  
   
   props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.starttls.enable","true");
   props.put("mail.smtp.host",host);
   props.put("mail.smtp.port","587");  
Authenticator auth = new Authenticator(){
      public PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }
};
Session session = Session.getInstance(props,auth); 
    try {  
     Message message = preparemessage(session,user,"rahulkirti10@gmail.com",amount,type,acc,ifsc,email);  
     Transport.send(message);  
   return 1;
     } catch (MessagingException e) {e.printStackTrace();
     return 0;}  
}  
}  