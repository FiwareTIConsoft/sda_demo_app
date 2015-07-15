package com.tilab.ca.sda.sda_demo_app.dao;

import com.tilab.ca.sda.sda_demo_app.model.StatsPreGenderHt;
import java.util.Optional;
import org.springframework.data.repository.Repository;


public interface GraGenderPreHtDao extends Repository<StatsPreGenderHt,Long>{
    
    public Optional<StatsPreGenderHt> findFirstByHtOrderByCreatedAtDesc(String ht);
}
