package org.n52.datareader.controller;

import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DatabaseController {
    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/allMeasurements")
    public List<Measurement> findAll(){
        List<Measurement> listMeasurementsResult = databaseService.findAll();
        return listMeasurementsResult;
    }

    @GetMapping("/measuremntsCount")
    public Long count(){
        return databaseService.countMeasurements();
    }

    @PostMapping("/addMeasurement")
    public void addMeasurement(@RequestBody Measurement measurement){
        databaseService.addMeasurement(measurement);
    }

    @DeleteMapping("/deleteMeasurement/{id}")
    public void delete(@PathVariable String id){
        Long mid = Long.parseLong(id);
        databaseService.deleteMeasurementById(mid);
    }

}
