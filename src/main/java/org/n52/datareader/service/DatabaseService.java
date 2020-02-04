package org.n52.datareader.service;

import org.n52.datareader.model.Measurement;
import org.n52.datareader.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    MeasurementRepository measurementRepository;

    //CRUD operations using the CrudRepository
    public void addMeasurement(Measurement m){
        measurementRepository.save(m);
    }

    public Long countMeasurements(){
        return measurementRepository.count();
    }

    public List<Measurement> findAll(){
        Iterable<Measurement> m = measurementRepository.findAll();
        List measurements = new ArrayList<MessageDigest>();
        m.forEach(e -> measurements.add(m));
        return measurements;
    }

    public void deleteMeasurementById(Long id){
        measurementRepository.deleteById(id);
    }
}
