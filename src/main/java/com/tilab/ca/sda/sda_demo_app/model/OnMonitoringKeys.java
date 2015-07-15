package com.tilab.ca.sda.sda_demo_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tilab.ca.sda.sda_demo_app.utils.CustomDateSerializer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="on_monitoring_keys")
public class OnMonitoringKeys implements Serializable {
    
    @Id
    @Column(name="mon_key")
    private String key;
    
    @Column(name="on_monitoring_from")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date onMonitoringFrom;
    
    @JsonIgnore
    @Column(name="monitor_from_node")
    private String monitorFromNode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getOnMonitoringFrom() {
        return onMonitoringFrom;
    }

    public void setOnMonitoringFrom(Date onMonitoringFrom) {
        this.onMonitoringFrom = onMonitoringFrom;
    }

    public String getMonitorFromNode() {
        return monitorFromNode;
    }

    public void setMonitorFromNode(String monitorFromNode) {
        this.monitorFromNode = monitorFromNode;
    }
}
