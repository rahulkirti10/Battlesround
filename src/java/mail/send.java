package mail;
public class send {
    public static int sendmail(String to,String otp)
    {
        int status=mail.sendmail(to, otp);
        return status;
    }
  public static void main(String args[])
  {
      int status=sendmail("topa6798@gmail.com","222222");
  System.out.print(status);
  }
}
