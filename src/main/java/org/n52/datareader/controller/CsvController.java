package org.n52.datareader.controller;

import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DataReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CsvController {
    @Autowired
    private DataReaderHelper dataReaderHelper;

    @GetMapping(value ="/csv-data" ,  produces = "application/json")
    public List<Measurement> viewMeasurementsCSV() throws Exception{
        URI f = getClass().getResource("/data/file1.csv").toURI();
        Path asPath = Paths.get(f);
        return dataReaderHelper.readData(asPath);
    }
}

