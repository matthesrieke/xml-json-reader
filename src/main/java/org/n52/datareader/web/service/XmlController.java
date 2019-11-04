package org.n52.datareader.web.service;

import org.apache.tika.Tika;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.business.domain.Measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.MimeType;
import org.slf4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api")
public class XmlController {
    @Autowired
    List<DataFormatReader> readers;

    @Autowired
    private Logger LOG;

    @RequestMapping(method = RequestMethod.GET, value = "/{data}", produces = "application/json")
    public List<Measurement> readXmlData(@PathVariable("data") String dataType) throws Exception {
        List<Measurement> measurements = null;
        String mimeType;
        if (dataType.equals("xml-data"))
            mimeType = MediaType.APPLICATION_XML_VALUE;
       else if (dataType.equals("json-data"))
           mimeType = MediaType.APPLICATION_JSON_VALUE;
        else if (dataType.equals("csv-data"))
            mimeType = "text/csv";
        else return null;

        measurements = getData(mimeType);
        return measurements;
    }



    private  List<Measurement> getData(String mimeType) throws Exception {
        List<Measurement> result = new ArrayList<>();
        URI f = getClass().getResource("/data/file1.csv").toURI();
        Path asPath = Paths.get(f);

        if (Files.exists(asPath)) {

            Path directory = asPath.getParent();
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory);
            Spliterator<Path> F = directoryStream.spliterator();
            StreamSupport.stream(F, true).forEach(dataFile -> {
                try {
                    Tika tika = new Tika();
                    String dataFilemime = tika.detect(dataFile.toFile());
                    MimeType asMimeType = MimeType.valueOf(mimeType);
                    Optional<DataFormatReader> candidate = this.readers.stream()
                            .filter(h -> h.supportsDataFormat(asMimeType))
                            .findFirst();

                    if (candidate.isPresent() && dataFilemime.equals(mimeType)) {
                        result.addAll(candidate.get().readFile(dataFile));
                        LOG.info("Measurements of {}: {}", dataFile.toFile().getName(), result);
                    } else {
                        LOG.info("File type not supported: {}", dataFilemime);
                    }
                } catch (IOException e) {
                    LOG.warn("Could not read files", e);
                }

            });

        }
        return result;
    }
}
