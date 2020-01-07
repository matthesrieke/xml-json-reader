package org.n52.datareader.web.service;


import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.DataService;
import org.n52.datareader.business.service.DefaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Default {

    private final DefaultService defaultService;

    public Default(DefaultService defaultService) {
        this.defaultService = defaultService;
    }

    @GetMapping( value = "/measurements", produces = "application/json")
    public List<Measurement> getData()  {

        return defaultService.getData();
    }
}

