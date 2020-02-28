package org.n52.datareader.web.service;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.DataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JsonController {

    private final
    DataService dataService;

    public JsonController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping( value = "/json-data", produces = "application/json")
    public List<Measurement> readJsonData() throws IOException {
        String mimeType = MediaType.APPLICATION_JSON_VALUE;
        return dataService.getData(mimeType);
    }

}
