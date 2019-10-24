package org.n52.datareader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.model.Measurements;

import java.io.*;
import java.nio.file.Path;

public class CsvParser {
    Measurements measurements = new Measurements();


    public void readCsvFile(Object source) throws IOException {
        Reader in = null;

        if (source instanceof Path)
            in = new FileReader(( ((Path) source).toFile()));
        else if (source instanceof InputStream)
             in = (Reader) (new InputStreamReader((InputStream) source));

        CSVFormat csvFormat = CSVFormat.EXCEL.withDelimiter(';').withHeader("Time", "Value", "Comment").withSkipHeaderRecord();
        Iterable<CSVRecord> records = csvFormat.parse(in);
        for (CSVRecord record : records) {
            String time = (String) record.get("Time");
            String value = (String) record.get("Value");
            String comment = (String) record.get("Comment");
            Measurement measurement = new Measurement(Double.parseDouble(value), DateFormatter.formatDate(time), comment);
            measurements.getMeasurementList().add(measurement);
        }
    }

    public Measurements getContent() {
        return measurements;
    }
}