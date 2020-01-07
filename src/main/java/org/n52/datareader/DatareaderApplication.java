package org.n52.datareader;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2
@SpringBootApplication
public class DatareaderApplication {

    public DatareaderApplication() {
    }

    public static void main(String[] args) {
        SpringApplication myapp = new SpringApplication(DatareaderApplication.class);
        myapp.run(args);
        log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
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
