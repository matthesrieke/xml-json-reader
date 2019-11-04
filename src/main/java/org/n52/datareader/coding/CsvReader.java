/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.coding;

import java.io.IOException;
import java.io.InputStream;
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
        return read(p);
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        return read(stream);
    }

    private List<Measurement> read(Object o) throws IOException {
        Measurements measurements;
        CsvParser csvParser = new CsvParser();
        try {
            csvParser.readCsvFile(o);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        measurements = csvParser.getContent();
        return measurements.getMeasurements();
    }
}
