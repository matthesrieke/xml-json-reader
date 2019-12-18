/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author matthes rieke
 */
@XmlRootElement(name = "measurement")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"value" , "time" , "comment"})

public class Measurement {
    
    private double value;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'")
    private Date time;
    private String comment;

    public Measurement() {
    }
    
    public Measurement(double value, Date time, String comment) {
        this.value = value;
        this.time = time;
        this.comment = comment;
    }

    @JsonProperty("Value")
    public double getValue() {
        return value;
    }

    @XmlElement(name = "Value")
    public void setValue(double value) {
        this.value = value;
    }

    @JsonProperty("Time")
    public Date getTime() {
        return time;
    }
    @XmlElement(name = "Time")
    public void setTime(Date time) {
        this.time = time;
    }

    @JsonProperty("Comment")
    public String getComment() {
        return comment;
    }

    @XmlElement(name = "Comment")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(time, that.time) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, time, comment);
    }
}
