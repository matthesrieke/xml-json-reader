package org.n52.datareader.web.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.n52.datareader.business.domain.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class XmlControllerIntegrationTest {
    @Autowired
    XmlController xmlController;
    @Test
    public void readCsvDataTest() throws IOException {
        List <Measurement> measurements =xmlController.readXmlData();
        assertFalse(measurements.isEmpty());
        assertEquals(24,measurements.size());
    }

}