package com.tilab.ca.sda.sda_demo_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gra_aggr_ht_gender")
public class StatsPreGenderHt extends StatsPreGender {

    @Column(name = "ht")
    private String ht;

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }
}
