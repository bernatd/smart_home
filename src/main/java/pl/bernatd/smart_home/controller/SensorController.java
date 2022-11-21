package pl.bernatd.smart_home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.dto.SensorDto;
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
    public List<SensorDto> getSensors() {
        List<Sensor> sensors = service.getAllSensors();
        return mapper.mapToSensorDtoList(sensors);
    }

    @GetMapping(value = "{sensorId}")
    public SensorDto getSensor(@PathVariable Long sensorId) {
        return mapper.mapToSensorDto(service.getSensor(sensorId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensor = mapper.mapToSensor(sensorDto);
        service.saveSensor(sensor);
    }

    @PutMapping
    public SensorDto updateSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensor = mapper.mapToSensor(sensorDto);
        Sensor savedSensor = service.saveSensor(sensor);
        return mapper.mapToSensorDto(savedSensor);
    }

    @DeleteMapping(value = "{sensorId}")
    public void deleteSensor(@PathVariable Long sensorId) {
         service.deleteSensor(sensorId);
    }
}

