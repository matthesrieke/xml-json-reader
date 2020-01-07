package org.n52.datareader.business.service;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.data.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultService {
    private final MeasurementRepository measurementRepository;

    public DefaultService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }
    public List <Measurement> getData(){
        List <Measurement> measurements = new ArrayList <>();
        measurementRepository.findAll().iterator().forEachRemaining(measurements::add);
        return measurements;
    }
}
