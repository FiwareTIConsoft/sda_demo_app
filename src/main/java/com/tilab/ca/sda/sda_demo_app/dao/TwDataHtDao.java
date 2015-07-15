package com.tilab.ca.sda.sda_demo_app.dao;

import com.tilab.ca.sda.sda_demo_app.model.TwDataHt;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface TwDataHtDao extends Repository<TwDataHt,Long>{
    
    //@Query("from TwDataHt t where t.ht=?1 order by t.createdAt desc limit ?2")
    //public List<TwDataHt> lastTwsByHt(String ht,int numResults);
    public List<TwDataHt> findByHtOrderByCreatedAtDesc(String ht,Pageable pageable);
}
