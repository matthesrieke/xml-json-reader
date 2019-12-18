package org.n52.datareader.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.n52.datareader.coding.JsonReader;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DataReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeType;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
/*
Spring Boot provides the @WebMvcTest annotation
to fire up an application context that contains only
the beans needed for testing a web controller
 */
@WebMvcTest(JsonController.class)
class JsonControllerUnitTest {
    @InjectMocks
    JsonController jsonController;
    @Autowired
    private DataReaderHelper dataReaderHelper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JsonReader jsonReader;
    @Autowired
    ObjectMapper objectMapper;


    //Setting test data
    private List<Measurement> getMeasurementsSample() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        Measurement measurement1 = new Measurement(29.3340960593676, df.parse("2019-10-21T13:23:05Z"), "");
        Measurement measurement2 = new Measurement(27.4337992206333, df.parse("2019-10-21T13:23:10Z"), "");
        List<Measurement> result = new ArrayList<>();
        result.add(measurement1);
        result.add(measurement2);
        return result;
    }

    //Getting the path to the json file
    private Path getPath() throws URISyntaxException {
        URI f = getClass().getResource("/data/file3.json").toURI();
        return Paths.get(f);
    }

    @Test
    void test () throws Exception{
        Path p = getPath();
        //System.out.println(dataReaderHelper.readData(p).get(0));
    }

    @Test
    void ExpectedStatusIsOk() throws Exception{
        given(jsonReader.readFile(getPath())).willReturn(getMeasurementsSample());
        this.mockMvc.perform(get("/json-data")).andExpect(status().isOk());
    }

    @Test
    void readDataCsvFileReturningTheSameFirstMeasurement() throws  Exception {
        Path asPath = getPath();
        //mocks reply preparation
        when(jsonReader.supportsDataFormat(MimeType.valueOf("application/json"))).thenReturn(true);
        //Is there another way to tell thenReturn to return a List of Measurements other than using the test data??
        when(jsonReader.readStream(any())).thenReturn(getMeasurementsSample());
        //main object. This is not the mock
        assertEquals(dataReaderHelper.readData(asPath).get(0),getMeasurementsSample().get(0));
        verify(jsonReader,times(1)).supportsDataFormat(any());
    }

    @Test
    void JsonControllerListensToJsonRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/json-data").contentType("application/json")).andExpect(status().isOk());
    }

    /*
    This test is to that the input is successfully serialized into Java objects
     */
    @Test
    void JsonControllerInputSerializedIntoJavaObject() throws Exception{
        Measurement m = getMeasurementsSample().get(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/json-data").contentType("application/json").content(objectMapper.writeValueAsString(m))).andExpect(status().isOk());

    }
}