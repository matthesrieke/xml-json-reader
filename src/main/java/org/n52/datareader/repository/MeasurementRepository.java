

package org.n52.datareader.repository;


import org.n52.datareader.model.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
}

