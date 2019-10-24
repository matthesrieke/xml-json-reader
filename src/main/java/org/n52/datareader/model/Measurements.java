package org.n52.datareader.model;

import java.util.ArrayList;
import java.util.List;

public class Measurements {

    private List<Measurement> measurementList = new ArrayList<>();
    public void setMeasurementList(List<Measurement> measurementList) {
        this.measurementList = measurementList;
    }
    public List<Measurement> getMeasurementList() {
        return measurementList;
    }

    }
