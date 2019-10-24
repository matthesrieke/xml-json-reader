package org.n52.datareader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "measurements")
@XmlAccessorType(XmlAccessType.FIELD)
public class Measurements {
    @XmlElement(name = "measurement", type = Measurement.class)
    private List<Measurement> measurementList = new ArrayList<>();
    public void setMeasurements(List<Measurement> measurementList) {
        this.measurementList = measurementList;
    }
    public List<Measurement> getMeasurements() {
        return measurementList;
    }

    }
