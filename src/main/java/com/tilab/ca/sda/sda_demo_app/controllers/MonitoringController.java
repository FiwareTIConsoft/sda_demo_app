package com.tilab.ca.sda.sda_demo_app.controllers;

import com.tilab.ca.sda.sda_demo_app.dao.MonitoringDao;
import com.tilab.ca.sda.sda_demo_app.exceptions.SdaException;
import com.tilab.ca.sda.sda_demo_app.http.HttpConnector;
import com.tilab.ca.sda.sda_demo_app.model.OnMonitoringKeys;
import com.tilab.ca.sda.sda_demo_app.exceptions.HttpStatusCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.InternalErrorCodes;
import com.tilab.ca.sda.sda_demo_app.utils.StringUtils;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/monitor")
public class MonitoringController {
    
    private static final Logger log = LoggerFactory.getLogger(MonitoringController.class);
    
    @Autowired
    private MonitoringDao monitoringDao;
    
    @Autowired
    private HttpConnector httpConnector;
    
    
    @Value("${demoapp.monitoringNode}")
    private String monitoringNode;
    
    @Value("${demoapp.sdaHandlerBaseUri}")
    private String sdaHandlerBaseUri;
    
    @Value("${demoapp.sdaHandlerRestartUri}")
    private String sdaHandlerRestartUri;
    
    @RequestMapping(value="/ht/{ht}",method=POST)
    public OnMonitoringKeys addHtOnMon(@PathVariable String ht,@RequestParam(value="monNode",required = false) String monNode) {
        log.info(String.format("Adding ht %s on monitoring",ht));
        
        if(ht==null || ht.isEmpty())
            throw new SdaException("Missing ht param", HttpStatusCodes.BAD_REQUEST, InternalErrorCodes.HT_TO_MONITORING_NOT_PROVIDED);
        
        if(!ht.startsWith("#"))
            ht="#"+ht;
        
        if(monitoringDao.findOne(ht)!=null)
            throw new SdaException(String.format("Ht %s is already on monitoring",ht), 
                                   HttpStatusCodes.BAD_REQUEST, 
                                   InternalErrorCodes.HT_TO_MONITORING_ALREADY_EXISTS);
        
        OnMonitoringKeys omk=new OnMonitoringKeys();
        omk.setKey(ht);
        omk.setOnMonitoringFrom(new Date());
        omk.setMonitorFromNode(StringUtils.isNotBlank(monNode)?monNode:monitoringNode); 
        monitoringDao.save(omk);
        
        //restarting SDA to add the new entry on monitoring
        try{
            int responseCode=httpConnector.voidGet(sdaHandlerBaseUri+sdaHandlerRestartUri);
            if(responseCode!=200)
                throw new SdaException("Failed to restart sda", HttpStatusCodes.INTERNAL_SERVER_ERROR, InternalErrorCodes.SDA_RESTART_FAILURE);
        }catch(Exception e){
            log.error("Error on restarting sda",e);
            throw new SdaException("Failed to restart sda", HttpStatusCodes.INTERNAL_SERVER_ERROR, InternalErrorCodes.SDA_RESTART_FAILURE);
        }
        //-------------------------------------------------
        return omk;
    }
}
