package payment;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import java.io.IOException;
import java.io.PrintWriter;
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
public class coinsredirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
                    
Enumeration<String> paramNames = request.getParameterNames();
Map<String, String[]> mapData = request.getParameterMap();
TreeMap<String,String> parameters = new TreeMap<String,String>();
String paytmChecksum =  "";
while(paramNames.hasMoreElements()) {
	String paramName = (String)paramNames.nextElement();
	parameters.put(paramName,mapData.get(paramName)[0]);	
}
parameters.put("MID",paytm.MID);
parameters.put("CHANNEL_ID",paytm.CHANNEL_ID);
parameters.put("INDUSTRY_TYPE_ID",paytm.INDUSTRY_TYPE_ID);
parameters.put("WEBSITE",paytm.WEBSITE);
parameters.put("MOBILE_NO","8010447895");
parameters.put("EMAIL",email);
parameters.put("CALLBACK_URL", "http://localhost:8080/pubg/coinsadded");
String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytm.MERCHANT_KEY, parameters);
StringBuilder outputHtml = new StringBuilder();
outputHtml.append("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
outputHtml.append("<html>");
outputHtml.append("<head>");
outputHtml.append("<title>Merchant Check Out Page</title>");
outputHtml.append("</head>");
outputHtml.append("<body>");
outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
outputHtml.append("<form method='post' action='"+ paytm.PAYTM_URL +"' name='f1'>");
outputHtml.append("<table border='1'>");
outputHtml.append("<tbody>");
for(Map.Entry<String,String> entry : parameters.entrySet()) {
	String key = entry.getKey();
	String value = entry.getValue();
	outputHtml.append("<input type='hidden' name='"+key+"' value='" +value+"'>");	
}	  	  
outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='"+checkSum+"'>");
outputHtml.append("</tbody>");
outputHtml.append("</table>");
outputHtml.append("<script type='text/javascript'>");
outputHtml.append("document.f1.submit();");
outputHtml.append("</script>");
outputHtml.append("</form>");
outputHtml.append("</body>");
outputHtml.append("</html>");
out.println(outputHtml);
            
        } catch (Exception ex) {
            Logger.getLogger(coinsredirect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
