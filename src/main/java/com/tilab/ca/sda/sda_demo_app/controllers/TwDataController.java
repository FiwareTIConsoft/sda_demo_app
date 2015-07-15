
package com.tilab.ca.sda.sda_demo_app.controllers;

import com.tilab.ca.sda.sda_demo_app.dao.TwDataHtDao;
import com.tilab.ca.sda.sda_demo_app.model.TwDataHt;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TwDataController {
    
    private static final Logger log = LoggerFactory.getLogger(TwDataController.class);
    
    @Autowired
    private TwDataHtDao twDataHtDao;
    
    
    @RequestMapping(value="/tweets/{ht}",method=GET)
    public List<TwDataHt> lastTweetsHt(@PathVariable String ht,@RequestParam(value="numResults", defaultValue="10") int numResults) {
        log.info("Called lastTweetsHt with ht "+ht+" and numResults "+ numResults);
        Pageable tops = new PageRequest(0, numResults);
        return twDataHtDao.findByHtOrderByCreatedAtDesc(ht,tops);
        //return twDataHtDao.lastTwsByHt(ht, numResults);
    }
}
