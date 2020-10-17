/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesround;

import java.util.Map;
import java.util.TreeMap; 
import com.paytm.pg.merchant.CheckSumServiceHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
public class payments1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { 
            String paytmChecksum = null;

/* Create a TreeMap from the parameters received in POST */
TreeMap<String, String> paytmParams = new TreeMap<String, String>();
for (Entry<String, String[]> requestParamsEntry : request.getParameterMap().entrySet()) {
    if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
        paytmChecksum = requestParamsEntry.getValue()[0];
    } else {
        paytmParams.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
    }
}

/**
* Verify checksum
* Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys 
*/
boolean isValidChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum("t7ZJapTgf5qYlvIf", paytmParams, paytmChecksum);
if (isValidChecksum) {
	System.out.append("Checksum Matched");
} else {
	System.out.append("Checksum Mismatched");
}


        } catch (Exception ex) {
            Logger.getLogger(payments1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
