package org.n52.datareader;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.model.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.MimeType;

@SpringBootApplication
public class DatareaderApplication implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(DatareaderApplication.class);

    @Autowired
    List<DataFormatReader> readers;

    public static void main(String[] args) {
        SpringApplication.run(DatareaderApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        URI f = getClass().getResource("/data/file1.csv").toURI();
        Path asPath = Paths.get(f);

        if (Files.exists(asPath)) {
            Path directory = asPath.getParent();
            StreamSupport.stream(Files.newDirectoryStream(directory).spliterator(), true).forEach(dataFile -> {
                try {
                    String mimeType = Files.probeContentType(dataFile);
                    MimeType asMimeType = MimeType.valueOf(mimeType);

                    Optional<DataFormatReader> candidate = this.readers.stream()
                            .filter(h -> h.supportsDataFormat(asMimeType))
                            .findFirst();

                    if (candidate.isPresent()) {
                        List<Measurement> result = candidate.get().readFile(dataFile);
                        LOG.info("Measurements of {}: {}", dataFile.toFile().getName(), result);
                    } else {
                        LOG.info("File type not supported: {}", asMimeType);
                    }
                } catch (IOException e) {
                    LOG.warn("Could not read files", e);
                }

            });
        }

    }

}
