package org.n52.datareader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "measurements")
@XmlAccessorType(XmlAccessType.FIELD)

public class Measurements {

    @XmlElement(name = "measurement")
    private List<Measurement> measurements;

    public List<Measurement> getMeasurements(){
        return measurements;
    }

    public void setMeasurements(List<Measurement> ls){
        this.measurements = ls;
    }

}
