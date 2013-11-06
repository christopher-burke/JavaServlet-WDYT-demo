import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * WDYT Servlet to log into the CollegeNet WDYT service.
 * A valid user is redirected to a valid CollegeNET WDYT url.
 *
 * @author Christopher Burke
 */
public class WDYTServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
            PrintWriter out = response.getWriter();
            try {
                WDYTLogin wl = new WDYTLogin();
                String result = wl.getCourseEvaluationSession(request.getParameter("id"),request.getHeader("User-Agent"));
                response.sendRedirect(result);
                
                
            } catch (Exception ex) {
                Logger.getLogger(WDYTServlet.class.getName()).log(Level.SEVERE, null, ex);
                
                out.print("error");
                
            }
        
    }
    public void destroy() {
 
    }
}
