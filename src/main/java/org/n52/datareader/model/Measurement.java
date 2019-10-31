/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.model;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author matthes rieke
 */
@XmlRootElement(name = "measurement")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"value" , "time" , "comment"})
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
    @XmlElement(name = "Value")
    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }
    @XmlElement(name = "Time")
    public void setTime(Date time) {
        this.time = time;
    }

    @XmlElement(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        return "Measurement{" +
                "value=" + value +
                ", time=" + df.format(time) +
                ", comment='" + comment + '\'' +
                '}';
    }
}
