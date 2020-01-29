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
/*
This method uses Commons IO to convert the input stream into a file object
*/
@RestController
public class XmlController {

    @Autowired
    private DataReaderHelper dataReaderHelper;

    @GetMapping(value ="/xml-data", produces = "application/json")
    public List<Measurement> viewMeasurementsXml() throws Exception{

        InputStream in = this.getClass().getResourceAsStream("/data/file2.xml");
        File convertedFile = new File("convertedFile.xml");
        FileUtils.copyInputStreamToFile(in,convertedFile);
        URI f = convertedFile.toURI();
        Path asPath = Paths.get(f);
        return dataReaderHelper.readData(asPath);
    }
}
