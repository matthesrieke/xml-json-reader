package org.n52.datareader.service;

import org.apache.tika.Tika;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.model.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DataReaderHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DataReaderHelper.class);
    List<DataFormatReader> readers;

    public DataReaderHelper(List<DataFormatReader> readers) {
        this.readers = readers;
    }

    public List<Measurement> readData(Path p) throws Exception {
        File dataFile = p.toFile();
        Tika tika = new Tika();
        String mimeType = tika.detect(dataFile);
        MimeType asMimeType = MimeType.valueOf(mimeType);

        /*
        Optional helps avoiding null point exception
        A container object which may or may not contain a non-null value. If a value is present,
        isPresent() will return true and get() will return the value.
         */

        Optional<DataFormatReader> candidate = this.readers.stream()
                .filter(h -> h.supportsDataFormat(asMimeType))
                .findFirst();
        /*
        How come we are using readStream on an Optional object???
        Optional.get() returns a an object of type T
         */
        List<Measurement> result;
        if (candidate.isPresent()) {
            result = candidate.get().readStream(new FileInputStream(dataFile));
            LOG.info("Measurements of {}: {}", dataFile.getName(), result);
        } else {
            LOG.info("File type not supported: {}", asMimeType);
            result = Collections.emptyList();
        }
        return result;
    }
}