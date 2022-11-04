package pl.bernatd.smart_home.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.repository.SensorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbSensorService {

    @Autowired
    private SensorRepository repository;

    public List<Sensor> getAllSensors() {
        return repository.findAll();
    }

    public Sensor saveSensor(final Sensor sensor) {
        return repository.save(sensor);
    }

    public Optional<Sensor> getSensor(Long id) {
        return repository.findById(id);
    }

    public void deleteSensor(Long id) {
        repository.deleteById(id);
    }
}
