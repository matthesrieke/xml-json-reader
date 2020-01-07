package org.n52.datareader.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(XmlController.class)
class XmlControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DataService dataService;
    @InjectMocks
    XmlController xmlController;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @NotNull
    private List <Measurement> getMeasurementsSample() {
        Calendar myCalender = Calendar.getInstance();
        myCalender.set(2017, 2, 5);
        Date date = myCalender.getTime();
        Measurement measurement = new Measurement(25.5, date, "valid measurement");
        List<Measurement> measurements = new ArrayList <>();
        measurements.add(measurement);
        return measurements;
    }
    @Test
    public void readXmlDataTest() throws Exception {
        List<Measurement> measurementsSample = getMeasurementsSample();
        String jsonString = new ObjectMapper().writeValueAsString(measurementsSample);
        when(dataService.getData(MediaType.APPLICATION_XML_VALUE)).thenReturn(measurementsSample);
        mockMvc.perform(get("/api/xml-data")).andExpect(status().isOk()).andDo(print()).andExpect(content().json(jsonString));
    }


}