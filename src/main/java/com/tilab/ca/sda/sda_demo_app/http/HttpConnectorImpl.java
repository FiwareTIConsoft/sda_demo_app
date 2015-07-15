package com.tilab.ca.sda.sda_demo_app.http;

import com.tilab.ca.sda.sda_demo_app.exceptions.HttpStatusCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.InternalErrorCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.SdaException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jboss.logging.Logger;

public class HttpConnectorImpl implements HttpConnector{

    private static final Logger log=Logger.getLogger(HttpConnectorImpl.class);
    
    
    @Override
    public int voidGet(String url) {
        log.info("Void get to Url "+url);
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            return con.getResponseCode();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }
    
}
