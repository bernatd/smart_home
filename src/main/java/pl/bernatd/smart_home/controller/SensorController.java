package pl.bernatd.smart_home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.dto.SensorDto;
import pl.bernatd.smart_home.exceptions.SensorNotFoundException;
import pl.bernatd.smart_home.mapper.SensorMapper;
import pl.bernatd.smart_home.service.DbSensorService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorMapper mapper;

    private final DbSensorService service;

    @GetMapping
    public ResponseEntity<List<SensorDto>> getSensors() {
        List<Sensor> sensors = service.getAllSensors();
        return ResponseEntity.ok(mapper.mapToSensorDtoList(sensors));
    }

    @GetMapping(value = "{sensorId}")
    public ResponseEntity<SensorDto> getSensor(@PathVariable Long sensorId) throws SensorNotFoundException {
        return ResponseEntity.ok(mapper.mapToSensorDto(service.getSensor(sensorId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensor = mapper.mapToSensor(sensorDto);
        service.saveSensor(sensor);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<SensorDto> updateSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensor = mapper.mapToSensor(sensorDto);
        Sensor savedSensor = service.saveSensor(sensor);
        return ResponseEntity.ok(mapper.mapToSensorDto(savedSensor));
    }

    @DeleteMapping(value = "{sensorId}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long sensorId) {
        service.deleteSensor(sensorId);
        return ResponseEntity.ok().build();
    }
}

