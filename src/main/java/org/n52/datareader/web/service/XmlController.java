package org.n52.datareader.web.service;

import org.n52.datareader.business.service.DataService;
import org.n52.datareader.business.domain.Measurement;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class XmlController {

    private final
    DataService dataService;

    public XmlController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping( value = "/xml-data", produces = "application/json")
    public List<Measurement> readXmlData() throws IOException {
        String mimeType = MediaType.APPLICATION_XML_VALUE;
        return dataService.getData(mimeType);
    }
}
