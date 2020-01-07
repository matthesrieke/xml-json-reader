/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.domain.Measurements;
import org.n52.datareader.business.service.CsvParser;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

/**
 * @author matthes rieke
 */
@Component
public class CsvReader implements DataFormatReader {

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf("text/csv").isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException {
        Measurements measurements = new Measurements();
        CsvParser csvParser = new CsvParser();
        try {
            measurements.setMeasurements(csvParser.readCsvFile(Files.newInputStream(p)));
        } catch (ParseException e) {
            throw new IOException("Exception in Parsing the csv file");
        }

        return measurements.getMeasurements();

    }

}

