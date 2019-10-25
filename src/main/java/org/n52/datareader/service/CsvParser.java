package org.n52.datareader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.model.Measurements;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.text.ParseException;

public class CsvParser {
    Measurements measurements = new Measurements();


    public void readCsvFile(Object source) throws IOException, ParseException {
        Iterable<CSVRecord> records;
        DateFormatter dateFormatter = new DateFormatter();
        CSVFormat csvFormat = CSVFormat.EXCEL.withDelimiter(';').withHeader().withSkipHeaderRecord();

        if (source instanceof Path) {
            records = CSVParser.parse((Path) source, Charset.defaultCharset(), csvFormat);
        } else if (source instanceof InputStream) {
            records = CSVParser.parse((InputStream) source, Charset.defaultCharset(), csvFormat);
        } else throw new IOException("the given object is neither path  nor InputSteam Instance");

        for (CSVRecord record : records) {
            String time = (String) record.get(Measurement.TIME);
            String value = (String) record.get(Measurement.VALUE);
            String comment = (String) record.get(Measurement.COMMENT);
            Measurement measurement = new Measurement(Double.parseDouble(value), DateFormatter.formatStringToDate(time), comment);
            measurements.getMeasurements().add(measurement);
        }
    }

    public Measurements getContent() {
        return measurements;
    }
}