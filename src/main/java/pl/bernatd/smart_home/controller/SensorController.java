package pl.bernatd.smart_home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.service.DbSensorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final DbSensorService service;

    @GetMapping
    public List<Sensor> getSensors() {
        List<Sensor> sensors = service.getAllSensors();
        return sensors;
    }

    @GetMapping(value = "{sensorId}")
    public Optional<Sensor> getSensor(@PathVariable Long sensorId) {
        return service.getSensor(sensorId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSensor(@RequestBody Sensor sensor) {
        service.saveSensor(sensor);
    }

    @PutMapping
    public Sensor updateSensor(@RequestBody Sensor sensor) {
        Sensor savedSensor = service.saveSensor(sensor);
        return savedSensor;
    }

    @DeleteMapping(value = "sensorId")
    public void deleteSensor(@PathVariable Long sensorId) {
        service.deleteSensor(sensorId);
    }
}

