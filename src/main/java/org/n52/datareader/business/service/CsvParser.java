package org.n52.datareader.business.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.domain.Measurements;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;

public class CsvParser {



    public List<Measurement> readCsvFile(InputStream source) throws IOException, ParseException {
        Iterable<CSVRecord> records;
        DateFormatter dateFormatter = new DateFormatter();
        Measurements measurements = new Measurements();
        CSVFormat csvFormat = CSVFormat.EXCEL.withDelimiter(';').withHeader().withSkipHeaderRecord();

             records = CSVParser.parse(source, Charset.defaultCharset(),csvFormat);


        for (CSVRecord record : records) {
            String time = record.get(Measurement.TIME);
            String value = record.get(Measurement.VALUE);
            String comment = record.get(Measurement.COMMENT);
            Measurement measurement = new Measurement(Double.parseDouble(value), dateFormatter.unmarshal(time), comment);
            measurements.getMeasurements().add(measurement);
        }
        return measurements.getMeasurements();
    }


}