package org.n52.datareader.web.service;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CsvController {

    private final
    DataService dataService;

    public CsvController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping( value = "/csv-data", produces = "application/json")
    public List<Measurement> readCsvData() throws IOException {
        String  mimeType = "text/csv";
        return dataService.getData(mimeType);
    }
}
