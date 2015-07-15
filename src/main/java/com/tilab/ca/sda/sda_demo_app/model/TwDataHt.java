
package com.tilab.ca.sda.sda_demo_app.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tilab.ca.sda.sda_demo_app.utils.CustomDateSerializer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ht_tw_data")
public class TwDataHt implements Serializable {
    
    @Id
    private int id;
    
    private String ht;
    
    @JsonSerialize(using = CustomDateSerializer.class)
    @Column(name="createdAt")
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(name="post_id")
    private TwData twData;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public TwData getTwData() {
        return twData;
    }

    public void setTwData(TwData twData) {
        this.twData = twData;
    }
  
}
