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
 * @author matthes rieke
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "measurement", propOrder = {"time", "value", "comment"})
public class Measurement {

    public static final String VALUE = "Value";
    public static final String TIME = "Time";
    public static final String COMMENT = "Comment";

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

    @JsonProperty(VALUE)
    @XmlElement(name = VALUE)
    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    @XmlJavaTypeAdapter(DateFormatter.class)
    @JsonProperty(TIME)
    @XmlElement(name = TIME)
    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    @JsonProperty(COMMENT)
    @XmlElement(name = COMMENT)
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                VALUE + "=" + value +
                "," + TIME + "=" + new DateFormatter().marshal(time) +
                ", " + COMMENT + "='" + comment + '\'' +
                '}';
    }


}
