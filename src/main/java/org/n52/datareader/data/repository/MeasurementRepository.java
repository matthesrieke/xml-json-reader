package org.n52.datareader.data.repository;

import org.n52.datareader.business.domain.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
}
