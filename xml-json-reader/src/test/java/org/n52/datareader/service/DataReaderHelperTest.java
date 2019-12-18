package org.n52.datareader.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.n52.datareader.coding.CsvReader;
import org.n52.datareader.coding.DataFormatReader;
import org.n52.datareader.coding.JsonReader;
import org.n52.datareader.coding.XmlReader;
import org.n52.datareader.model.Measurement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.MimeType;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DataReaderHelperTest {

    // Initializing the list of readers
    List<DataFormatReader> readers;
    @InjectMocks
    private DataReaderHelper dataReaderHelper;
    @Mock
    private CsvReader csvReader;
    @Mock
    private JsonReader jsonReader;
    @Mock
    private XmlReader xmlReader;

    @BeforeEach
    public  void setup(){
        MockitoAnnotations.initMocks(this);
        readers = new ArrayList<>();
        readers.add(xmlReader);
        readers.add(csvReader);
        readers.add(jsonReader);
        dataReaderHelper= new DataReaderHelper(readers);
    }

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

    //Getting the path to the csv file
    private Path getPath() throws URISyntaxException {
        URI f = getClass().getResource("/data/file1.csv").toURI();
        return Paths.get(f);
    }

    @Test
    void readDataCsvFileReturningTheSameFirstMeasurement() throws  Exception {
        Path asPath = getPath();
        //mocks reply preparation
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(true);
        //Is there another way to tell thenReturn to return a List of Measurements other than using the test data??
        when(csvReader.readStream(any())).thenReturn(getMeasurementsSample());
        //main object. This is not the mock
        assertEquals(dataReaderHelper.readData(asPath).get(0),getMeasurementsSample().get(0));
        verify(csvReader,times(1)).supportsDataFormat(any());
    }

    @Test
    void readDataCsvFileReturnListOfMeasurements() throws Exception{
        Path asPath = getPath();
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(true);
        when(csvReader.readStream(any())).thenReturn(getMeasurementsSample());
        assertEquals(dataReaderHelper.readData(asPath).getClass(),getMeasurementsSample().getClass());
    }

    @Test
    void readDataCsvFileReturnNullWhenMimeTypeIsNotSupported() throws Exception{
        Path asPath = getPath();
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(false);
        assertEquals(dataReaderHelper.readData(asPath).size(),0);
    }

    @Test
    void readDataCsvFileReturnsListOfSizeZeroWhenCandidateIsNotPresent()throws Exception{
        Path asPath = getPath();
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(false);
        when(csvReader.readStream(any())).thenReturn(Collections.emptyList());
        assertEquals(dataReaderHelper.readData(asPath).size(),0);

    }

    @Test
    void readDataCsvFileReturnMeasurementListOfSize2()throws Exception {
        // we only need this file reference as Tika depends on it
        // the actual data is mocked
        // In this test the readData method is tested if it returns a list of size 2 (which is the size of the test data)
        Path asPath = getPath();
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(true);
        when(csvReader.readStream(any())).thenReturn(getMeasurementsSample());
        assertEquals(dataReaderHelper.readData(asPath).size(), 2);
    }

    @Test
    void readDataReturnsNonNullMeasurements()throws Exception {
        Path asPath = getPath();
        when(csvReader.supportsDataFormat(MimeType.valueOf("text/csv"))).thenReturn(true);
        when(csvReader.readStream(any())).thenReturn(getMeasurementsSample());
        assertNotNull(dataReaderHelper.readData(asPath).get(0).getValue());
        assertNotNull(dataReaderHelper.readData(asPath).get(0).getComment());
        assertNotNull(dataReaderHelper.readData(asPath).get(0).getTime());
    }

}