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
public class jsonController {

    @Autowired
    private DataReaderHelper dataReaderHelper;

    @GetMapping(value ="/json-data")
    public List<Measurement> viewMeasurementsJson() throws Exception{
        URI f = getClass().getResource("/data/file3.json").toURI();
        Path asPath = Paths.get(f);
        return dataReaderHelper.readData(asPath);
    }
}
