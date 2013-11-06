import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.net.URL;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 *
 * WDYT Login returns the URL received from the CollegeNet WDYT Service.
 * Apache Axis is used to connect to the collegenet service.
 *
 * This code is derived from the CollegeNet WDYT Docs.
 */
public class WDYTLogin {
    public static String getCourseEvaluationSession( String id, String salt) throws Exception {
        String username = "";   // To auth your system to Applyweb  
        String password = "";   // To auth your system to Applyweb 
        String target = "";     //  }
        String qname = "";      //  }   This information is provided in the WDYT Docs.
        String method = "";     //  }

        Call call = (Call) new Service().createCall();
        call.setUsername(username);
        call.setPassword(password);
        call.setTargetEndpointAddress(new URL(target));
        call.setOperationName(new QName(qname, method));

        String result = (String) call.invoke(new Object[]{id, salt});

        // A url to the CollegeNet WDYT service.
        return result;
    }
    
}
