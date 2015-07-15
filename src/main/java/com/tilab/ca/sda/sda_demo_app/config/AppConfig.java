package com.tilab.ca.sda.sda_demo_app.config;

import com.tilab.ca.sda.sda_demo_app.http.HttpConnector;
import com.tilab.ca.sda.sda_demo_app.http.HttpConnectorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public HttpConnector httpConnector(){
        return new HttpConnectorImpl();
    }
}
