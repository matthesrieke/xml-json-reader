package org.n52.datareader.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.model.Measurements;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonParser {

    Measurements measurements = new Measurements();

    public void readJson(Object in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat(DateFormatter.CUSTOM_FORMAT_STRING);
        objectMapper.setDateFormat(df);
        if (in instanceof File)
            measurements.setMeasurements(objectMapper.readValue((File) in, new TypeReference<List<Measurement>>() {
            }));
        else if (in instanceof InputStream)
            measurements.setMeasurements(objectMapper.readValue((InputStream) in, new TypeReference<List<Measurement>>() {
            }));
    }


    public Measurements getContent() {
        return measurements;
    }

}
