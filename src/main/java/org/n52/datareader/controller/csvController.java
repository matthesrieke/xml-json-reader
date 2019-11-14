package org.n52.datareader.controller;

import org.n52.datareader.coding.csvReader;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DataReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.util.MimeType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class csvController {
    @Autowired
    private DataReaderHelper dataReaderHelper;

    @GetMapping(value ="/csv-data")
    public List<Measurement> viewMeasurementsJson() throws Exception{
        URI f = getClass().getResource("/data/file1.csv").toURI();
        Path asPath = Paths.get(f);
        return dataReaderHelper.readData(asPath);
    }
}

