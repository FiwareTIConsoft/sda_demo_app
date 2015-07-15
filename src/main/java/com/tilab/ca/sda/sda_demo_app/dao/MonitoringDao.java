package com.tilab.ca.sda.sda_demo_app.dao;

import com.tilab.ca.sda.sda_demo_app.model.OnMonitoringKeys;
import org.springframework.data.repository.CrudRepository;


public interface MonitoringDao extends CrudRepository<OnMonitoringKeys,String>{
    
}
