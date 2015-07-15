package com.tilab.ca.sda.sda_demo_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    
    
    @RequestMapping(value="/test",method=GET)
    public String index() {
        return "It Works!";
    }
    
    
    
}
