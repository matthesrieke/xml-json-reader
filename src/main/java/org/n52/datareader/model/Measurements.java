package org.n52.datareader.model;

import org.apache.commons.csv.CSVRecord;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DateFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Measurements {

    private List<Measurement> measurementList = new ArrayList<>();
    public void setMeasurementList(List<Measurement> measurementList) {
        this.measurementList = measurementList;
    }
    public List<Measurement> getMeasurements() {
        return measurementList;
    }

    }
