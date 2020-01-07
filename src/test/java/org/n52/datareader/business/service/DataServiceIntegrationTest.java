package org.n52.datareader.business.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.n52.datareader.business.domain.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.InvalidMimeTypeException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DataServiceIntegrationTest {

    @Autowired
    DataService dataService;

    @Test
    void get_data_csv_file() throws IOException{
    List<Measurement>measurements =dataService.getData("text/csv");
        assertFalse(measurements.isEmpty());
        assertEquals(24,measurements.size());

    }

    @Test
    void get_data_json_file() throws IOException{
        List<Measurement>measurements =dataService.getData(MediaType.APPLICATION_JSON_VALUE);
        assertFalse(measurements.isEmpty());
        assertEquals(24,measurements.size());
    }

    @Test
    void get_data_xml_file() throws IOException{
        List<Measurement>measurements =dataService.getData(MediaType.APPLICATION_XML_VALUE);
        assertFalse(measurements.isEmpty());
        assertEquals(24,measurements.size());
    }
    @Test
    void get_data_not_supported_mimeType() {
         assertThrows(InvalidMimeTypeException.class, () -> dataService.getData("text"));

    }
@Test
void get_data_File_null_mimeType_exception(){
    Exception throwException = assertThrows(Exception.class, () -> dataService.getData(null));
    assertEquals("Invalid mime type \"null\": 'mimeType' must not be empty",throwException.getMessage());
}

}