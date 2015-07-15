package com.tilab.ca.sda.sda_demo_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="gra_aggr_geo_gender")
public class StatsPreGenderGeo extends StatsPreGender{

    @Column(name = "lat_trunc")
    private double latTrunc;

    @Column(name = "long_trunc")
    private double longTrunc;

   
    public double getLatTrunc() {
        return latTrunc;
    }

    public void setLatTrunc(double latTrunc) {
        this.latTrunc = latTrunc;
    }

    public double getLongTrunc() {
        return longTrunc;
    }

    public void setLongTrunc(double longTrunc) {
        this.longTrunc = longTrunc;
    }
}
