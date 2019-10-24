/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.n52.datareader.service.DateFormatter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 *
 * @author matthes rieke
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "measurement",propOrder = {"time","value","comment"})
public class Measurement {
    
    private double value;
    private Date time;
    private String comment;

    public Measurement() {
    }
    
    public Measurement(double value, Date time, String comment) {
        this.value = value;
        this.time = time;
        this.comment = comment;
    }

    public double getValue() {
        return value;
    }
    @JsonProperty("Value")
    @XmlElement(name = "Value")
    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }
    @XmlJavaTypeAdapter(DateFormatter.class)
    @JsonProperty("Time")
    @XmlElement(name = "Time")
    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }
    @JsonProperty("Comment")
    @XmlElement(name = "Comment")
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", time=" + new DateFormatter().marshal(time) +
                ", comment='" + comment + '\'' +
                '}';
    }


}
