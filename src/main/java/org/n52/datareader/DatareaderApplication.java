package org.n52.datareader;

import java.util.List;

import org.n52.datareader.coding.DataFormatReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DatareaderApplication {
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(DatareaderApplication.class);
    }

    @Autowired
    List<DataFormatReader> readers;

    public static void main(String[] args) {
        SpringApplication.run(DatareaderApplication.class, args);
    }

    /** @Override
    public void afterPropertiesSet() throws Exception {
        URI f = getClass().getResource("/data/file1.csv").toURI();
        Path asPath = Paths.get(f);

        if (Files.exists(asPath)) {
            Path directory = asPath.getParent();
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory);
            Spliterator<Path> F = directoryStream.spliterator();
            StreamSupport.stream(F, true).forEach(dataFile -> {
                try {
                    Tika tika = new Tika();
                    String mimeType = tika.detect(dataFile.toFile());
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

    }*/

}
