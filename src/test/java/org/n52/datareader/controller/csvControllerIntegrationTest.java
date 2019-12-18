package org.n52.datareader.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.n52.datareader.model.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class csvControllerIntegrationTest {

    @Autowired
    CsvController controller;

    //Testing the status code is ok
    @Test
    public void csvResponseStatusIsOk() throws ClientProtocolException, IOException {

        HttpUriRequest request = new HttpGet("http://localhost:8080/csv-data");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        //int statusCode = httpResponse.getStatusLine().getStatusCode();
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    //Testing the size of the returned file
    @Test
    public void listReturnedHasTheSizeOf24()throws Exception{
        assertEquals(controller.viewMeasurementsCSV().size(), 24);
    }


    //Testing if the response is empty
    @Test
    public void contextLoad() throws Exception {
        assertThat(controller).isNotNull();
        //assertThat(controller).isNull();
    }
}