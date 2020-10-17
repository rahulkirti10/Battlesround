package mail;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
public class mail {  
    public static Message preparemessage(Session session,String user,String pass,String otp) throws AddressException, MessagingException
    {
        Message m=new MimeMessage(session);
        m.setFrom(new InternetAddress(user));
        m.setRecipient(Message.RecipientType.TO, new InternetAddress(pass));
        m.setSubject("Battlesround Email Veryfing OTP");
        String htmlCode="<h1>Your Email Veryfing OTP:</h1>"+otp;
        m.setContent(htmlCode,"text/html");
        return m;
    }   
 public static int sendmail(String recipient,String otp) {  
  
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
     Message message = preparemessage(session,user,recipient,otp);  
     Transport.send(message);  
   return 1;
     } catch (MessagingException e) {e.printStackTrace();
     return 0;}  
}  
}  