package com.tilab.ca.sda.sda_demo_app.controllers;

import com.tilab.ca.sda.sda_demo_app.dao.GraGenderPreHtDao;
import com.tilab.ca.sda.sda_demo_app.exceptions.SdaException;
import com.tilab.ca.sda.sda_demo_app.model.StatsPreGenderHt;
import com.tilab.ca.sda.sda_demo_app.exceptions.HttpStatusCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.InternalErrorCodes;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/gender/hts")
public class GenderHtController {
    
    private static final Logger log = LoggerFactory.getLogger(GenderHtController.class);
    
    @Autowired
    private GraGenderPreHtDao graGenderPreHtDao;
    
    
    @RequestMapping(value="/{ht}/last",method=GET)
    public StatsPreGenderHt lastHt(@PathVariable String ht) {
        log.info("Called lastHt with ht "+ht);
        StatsPreGenderHt s=new StatsPreGenderHt();
        return graGenderPreHtDao.findFirstByHtOrderByCreatedAtDesc(ht)
                .orElseThrow(() -> new SdaException("No data available for ht "+ht,
                                                    HttpStatusCodes.NOT_FOUND,
                                                    InternalErrorCodes.GENDER_HT_NOT_FOUND));
    }
    
    @RequestMapping(value="/{ht}/history",method=GET)
    public List<StatsPreGenderHt> getHtTwHistory(@PathVariable String ht,
                                           @RequestParam(value="gender",required = true) String gender,
                                           @RequestParam(value="from",required = true) String from,
                                           @RequestParam(value="to",required = true) String to) {
        
        log.info("Called history with ht "+ht+" from="+from+" and to="+to);
        ZonedDateTime zFrom=ZonedDateTime.parse(from.replace(" ", "+"));
        ZonedDateTime zTo=ZonedDateTime.parse(to.replace(" ", "+"));
        List<StatsPreGenderHt> postsHistoryList=graGenderPreHtDao.findByHtAndCreatedAtBetweenOrderByCreatedAtAsc(ht,Date.from(zFrom.toInstant()), Date.from(zTo.toInstant()));
        return postsHistoryList;
    }
}
