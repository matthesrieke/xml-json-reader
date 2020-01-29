package org.n52.datareader.controller;

import org.apache.commons.io.FileUtils;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DataReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CsvController {
    @Autowired
    private DataReaderHelper dataReaderHelper;

    @GetMapping(value ="/csv-data")
    public List<Measurement> viewMeasurementsCSV() throws Exception{

        InputStream in = this.getClass().getResourceAsStream("/data/file1.csv");
        File convertedFile = new File("convertedFile.csv");
        FileUtils.copyInputStreamToFile(in,convertedFile);
        URI f = convertedFile.toURI();
        Path asPath = Paths.get(f);
        return dataReaderHelper.readData(asPath);
    }
}

