/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.model;

import org.n52.datareader.service.DateFormatter;

import java.util.Date;

/**
 *
 * @author matthes rieke
 */
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

    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Measurement{" +
                VALUE + "=" + value +
                "," + TIME + "=" + DateFormatter.formatDateToString(time)+
                ", " + COMMENT + "='" + comment + '\'' +
                '}';
    }

    
}
