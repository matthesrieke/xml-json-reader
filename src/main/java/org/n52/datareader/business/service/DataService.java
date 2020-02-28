package org.n52.datareader.business.service;

import lombok.extern.log4j.Log4j2;
import org.apache.tika.Tika;
import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.coding.DataFormatReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.StreamSupport;
@Log4j2
@Service
public class DataService {
    private   List<DataFormatReader> readers;
    @Value(value = "${name}") String name;

    public DataService(List<DataFormatReader> readers) {
        this.readers = readers;
    }

    @org.jetbrains.annotations.NotNull
    public List<Measurement> getData(String mimeType) throws IOException {
        List<Measurement> result = new ArrayList<>();
        URI f = null;
        try {
            f = getClass().getResource("/data/file1.csv").toURI();
        } catch (URISyntaxException e) {
            throw new IOException("URI Exception caught");
        }

        Path asPath = Paths.get(f);
        if (Files.exists(asPath)) {

            Path directory = asPath.getParent();
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory);
            Spliterator<Path> F = directoryStream.spliterator();
            StreamSupport.stream(F, true)
                    .filter(path -> !(Files.isDirectory(path)))
                    .forEach( dataFile -> {
                        try {
                            result.addAll(retrieveMeasurements(mimeType, dataFile));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

            );

        }
        return result;
    }


private List<Measurement> retrieveMeasurements(String mimeType, Path dataFile) throws IOException {
        List<Measurement> result = new ArrayList<>();

            Tika tika = new Tika();
            String dataFileMime = tika.detect(dataFile.toFile());
            MimeType asMimeType = MimeType.valueOf(mimeType);
            Optional<DataFormatReader> candidate = this.readers.stream()
                    .filter(h -> h.supportsDataFormat(asMimeType))
                    .findFirst();


            if (candidate.isPresent() && dataFileMime.equals(mimeType)) {
                result.addAll(candidate.get().readFile(dataFile));
                log.info(name);
                log.info("Measurements of {}:", dataFile.toFile().getName());
            }

        return result;
    }


}

