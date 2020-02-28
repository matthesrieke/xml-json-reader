package org.n52.datareader.business.service;

import org.junit.jupiter.api.Test;
import org.n52.datareader.business.domain.Measurement;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserIntegrationTest {
    private final CsvParser csvParser = new CsvParser();

    @Test
    void readCsvFile_from_input_stream() throws URISyntaxException, IOException, ParseException {
        InputStream source = Files.newInputStream(Paths.get(getClass().getResource("/data/file1.csv").toURI()));
        List<Measurement> result = csvParser.readCsvFile(source);
        assertNotNull(result);
        assertEquals(result.size(), 24);
    }

    @Test
    void readCsvFile_from_not_csv_file() throws URISyntaxException, IOException {

        InputStream source = Files.newInputStream(Paths.get(getClass().getResource("/data/file3.json").toURI()));
        assertThrows(IllegalArgumentException.class, () -> csvParser.readCsvFile(source));

    }
    @Test
    void readCsvFile_from_wrong_csv_header_format_file() throws URISyntaxException, IOException {

        InputStream source = Files.newInputStream(Paths.get(getClass().getResource("/data/test/file4.csv").toURI()));
        assertThrows(IllegalArgumentException.class, () -> csvParser.readCsvFile(source));


    }
    @Test
    void readCsvFile_from_wrong_csv_header_not_exist_file() throws URISyntaxException, IOException, ParseException {

        InputStream source = Files.newInputStream(Paths.get(getClass().getResource("/data/test/file5.csv").toURI()));
        assertEquals(csvParser.readCsvFile(source).size(),0);


    }
}