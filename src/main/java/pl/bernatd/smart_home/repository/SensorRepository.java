package pl.bernatd.smart_home.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bernatd.smart_home.domain.Sensor;

import java.util.List;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
    List<Sensor> findAll();
}
