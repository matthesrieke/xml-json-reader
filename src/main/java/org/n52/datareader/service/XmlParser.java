package org.n52.datareader.service;

import org.n52.datareader.model.Measurements;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.n52.datareader.model.Measurement;

import java.util.ArrayList;
import java.util.List;

public class XmlParser extends DefaultHandler {
    private static final String MEASUREMENTS = "measurements";
    private static final String MEASUREMENT = "measurement";

    private Measurements measurements;
    private String elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        measurements = new Measurements();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case MEASUREMENTS:
                measurements.setMeasurementList(new ArrayList<>());
                break;
            case MEASUREMENT:
                measurements.getMeasurements().add(new Measurement());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case Measurement.VALUE:
                latestMeasurement().setValue(Double.parseDouble(elementValue));
                ;
                break;
            case Measurement.TIME:
                latestMeasurement().setTime(DateFormatter.formatStringToDate(elementValue));
                break;
            case Measurement.COMMENT:
                latestMeasurement().setComment(elementValue);
                break;
        }
    }

    private Measurement latestMeasurement() {
        List<Measurement> measurementList = measurements.getMeasurements();
        int latestArticleIndex = measurementList.size() - 1;
        return measurementList.get(latestArticleIndex);
    }

    public Measurements getContent() {
        return measurements;
    }

}