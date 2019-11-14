package org.n52.datareader.service;

import org.apache.tika.Tika;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.model.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Component
public class DataReaderHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DataReaderHelper.class);

    @Autowired
    List<DataFormatReader> readers;

    public List<Measurement>  readData(Path p)throws Exception{

        List<Measurement> result = null;
        File dataFile = p.toFile();
        Tika tika = new Tika();
        String mimeType = tika.detect(dataFile);
        MimeType asMimeType = MimeType.valueOf(mimeType);

        Optional<DataFormatReader> candidate = this.readers.stream()
                .filter(h -> h.supportsDataFormat(asMimeType))
                .findFirst();

        if (candidate.isPresent()) {
            result = candidate.get().readStream(new FileInputStream(dataFile));
            LOG.info("Measurements of {}: {}", dataFile.getName(), result);

        } else {
            LOG.info("File type not supported: {}", asMimeType);
        }
        return result;
    }
}
