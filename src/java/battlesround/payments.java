
package battlesround;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class payments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { 
            /* initialize a TreeMap object */
TreeMap<String, String> paytmParams = new TreeMap<String, String>();

/* Find your MID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
paytmParams.put("MID", "jFxpNk14857799837309");

/* Find your WEBSITE in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
paytmParams.put("WEBSITE", "WEBSTAGING");

/* Find your INDUSTRY_TYPE_ID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
paytmParams.put("INDUSTRY_TYPE_ID", "Retail");

/* WEB for website and WAP for Mobile-websites or App */
paytmParams.put("CHANNEL_ID", "WEB");

/* Enter your unique order id */
paytmParams.put("ORDER_ID", "1001");

/* unique id that belongs to your customer */
paytmParams.put("CUST_ID", "10010");

/* customer's mobile number */
paytmParams.put("MOBILE_NO", "8010447895");

/* customer's email */
paytmParams.put("EMAIL", "rahulkirti10@gmail.com");

/**
* Amount in INR that is payble by customer
* this should be numeric with optionally having two decimal points
*/
paytmParams.put("TXN_AMOUNT", "1");

/* on completion of transaction, we will send you the response on this URL */
paytmParams.put("CALLBACK_URL", "http://localhost:22465/pubg/home.jsp");

/**
* Generate checksum for parameters we have
* You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
* Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys 
*/
String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum("t7ZJapTgf5qYlvIf", paytmParams);

/* for Staging */
String url = "https://localhost22465/pubg/pay.html"
        
        ;

/* for Production */
// String url = "https://securegw.paytm.in/order/process";

/* Prepare HTML Form and Submit to Paytm */
StringBuilder outputHtml = new StringBuilder();
outputHtml.append("<html>");
outputHtml.append("<head>");
outputHtml.append("<title>Merchant Checkout Page</title>");
outputHtml.append("</head>");
outputHtml.append("<body>");
outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
outputHtml.append("<form method='post' action='" + url + "' name='paytm_form'>");

for(Map.Entry<String,String> entry : paytmParams.entrySet()) {
    outputHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'>");
}

outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='" + checksum + "'>");
outputHtml.append("</form>");
outputHtml.append("<script type='text/javascript'>");
outputHtml.append("document.paytm_form.submit();");
outputHtml.append("</script>");
outputHtml.append("</body>");
outputHtml.append("</html>");
        } catch (Exception ex) {
            Logger.getLogger(payments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
