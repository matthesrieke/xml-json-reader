package org.n52.datareader.business.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.coding.CsvReader;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.coding.JsonReader;
import org.n52.datareader.coding.XmlReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DataServiceUnitTest {

    private @Mock
    CsvReader csvReader;
    private @Mock
    JsonReader jsonReader;
    private @Mock
    XmlReader xmlReader;
    private DataService dataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        // another solution is by using a spy.
        List<DataFormatReader> readers = Arrays.asList(csvReader, jsonReader, xmlReader);
        dataService = new DataService(readers);

    }
    @Test
    void getData_from_jason_reader() throws IOException {
        List<Measurement> measurements = getMeasurementsSample();


        when(jsonReader.supportsDataFormat(eq(MediaType.APPLICATION_JSON))).thenReturn(true);
        when(jsonReader.readFile(any(Path.class))).thenReturn(measurements);
        List<Measurement> result = dataService.getData(MediaType.APPLICATION_JSON_VALUE);
        assertEquals(result.get(0),measurements.get(0));
        verify(jsonReader, atLeast(1)).supportsDataFormat(any(MimeType.class));
        verify(jsonReader, times(1)).readFile(any());
    }

    @NotNull
    private List<Measurement> getMeasurementsSample() {
        Calendar myCalender = Calendar.getInstance();
        myCalender.set(2017, 2, 5);
        Date date = myCalender.getTime();
        Measurement measurement = new Measurement(25.5, date, "valid measurement");
        List<Measurement> measurements = new ArrayList<>();
        measurements.add(measurement);
        return measurements;
    }




    @Test
    void getData_from_csv_reader() throws IOException {
        List<Measurement> measurements = getMeasurementsSample();


        when(csvReader.supportsDataFormat(eq(MimeType.valueOf("text/csv")))).thenReturn(true);
        when(csvReader.readFile(any(Path.class))).thenReturn(measurements);
        List<Measurement> result = dataService.getData("text/csv");
        assertEquals(result.get(0),measurements.get(0));
        verify(csvReader, atLeast(1)).supportsDataFormat(any(MimeType.class));
        verify(csvReader, times(1)).readFile(any());
    }
    @Test
    void getData_from_xml_reader() throws IOException {
        List<Measurement> measurements = getMeasurementsSample();


        when(xmlReader.supportsDataFormat(eq(MediaType.APPLICATION_XML))).thenReturn(true);
        when(xmlReader.readFile(any(Path.class))).thenReturn(measurements);
        List<Measurement> result = dataService.getData(MediaType.APPLICATION_XML_VALUE);
        assertEquals(result.get(0),measurements.get(0));
        verify(xmlReader, atLeast(1)).supportsDataFormat(any(MimeType.class));
        verify(xmlReader, times(1)).readFile(any());
    }
    @Test
    void getData_from_unsupported_reader() throws IOException{
        when(xmlReader.supportsDataFormat(AdditionalMatchers.not(
                or( or(eq(MimeType.valueOf("text/csv")),eq(MediaType.APPLICATION_XML)),eq(MediaType.APPLICATION_JSON))))).thenReturn(false);

        // FileNotFoundException will be thrown too
        List<Measurement> result = dataService.getData(MediaType.APPLICATION_PDF_VALUE);
        assertTrue(result.isEmpty());
    }
}