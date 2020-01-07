package org.n52.datareader.business.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.domain.Measurements;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class JsonParser {

    public List<Measurement> readJson(InputStream in) throws IOException {
        Measurements measurements = new Measurements();
        ObjectMapper objectMapper = new ObjectMapper();
        measurements.setMeasurements(objectMapper.readValue(in, new TypeReference<List<Measurement>>() {}));
        return measurements.getMeasurements();
    }
}
