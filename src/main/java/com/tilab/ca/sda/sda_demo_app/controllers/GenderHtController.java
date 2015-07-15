package com.tilab.ca.sda.sda_demo_app.controllers;

import com.tilab.ca.sda.sda_demo_app.dao.GraGenderPreHtDao;
import com.tilab.ca.sda.sda_demo_app.exceptions.SdaException;
import com.tilab.ca.sda.sda_demo_app.model.StatsPreGenderHt;
import com.tilab.ca.sda.sda_demo_app.exceptions.HttpStatusCodes;
import com.tilab.ca.sda.sda_demo_app.exceptions.InternalErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
