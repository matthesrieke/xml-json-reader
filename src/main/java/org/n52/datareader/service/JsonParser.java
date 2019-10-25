package org.n52.datareader.service;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.model.Measurements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class JsonParser {

    private Measurements measurements;
    private JSONParser jsonParser;

    public JsonParser() {
        this.measurements = new Measurements();
        this.jsonParser = new JSONParser();
    }

    public void readJson(Object in) throws IOException, ParseException {
        Iterable<Object> jsonArray;
        if (in instanceof Path) {
            File file = ((Path) in).toFile();
            jsonArray = (Iterable<Object>) jsonParser.parse(new FileReader(file));


        } else if (in instanceof InputStream) {
            jsonArray = (Iterable<Object>) jsonParser.parse(new InputStreamReader((InputStream) in, StandardCharsets.UTF_8));
        } else throw new IOException("the given object is neither path  nor InputSteam Instance");
        jsonArray.forEach(jsonObject -> {
            Measurement measurement = parseMeasurementObject((JSONObject) jsonObject);
            measurements.getMeasurements().add(measurement);
        });
    }

    private Measurement parseMeasurementObject(JSONObject jsonObject) {

        //Get Measurement Value
        Double value = (Double) jsonObject.get(Measurement.VALUE);
        //Get Date
        String dateString = (String) jsonObject.get(Measurement.TIME);
        //Get Comment
        String comment = (String) jsonObject.get(Measurement.COMMENT);
        //return an Object of Measurement
        return new Measurement(value, DateFormatter.formatStringToDate(dateString), comment);
    }

    public Measurements getContent() {
        return measurements;
    }

}
