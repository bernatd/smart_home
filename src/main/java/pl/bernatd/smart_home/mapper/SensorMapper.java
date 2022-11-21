package pl.bernatd.smart_home.mapper;

import org.springframework.stereotype.Service;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.dto.SensorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorMapper {

    public Sensor mapToSensor(final SensorDto sensorDto) {
        return new Sensor(sensorDto.getId(),
                sensorDto.getName(),
                sensorDto.getType(),
                sensorDto.getPin(),
                sensorDto.getUnits(),
                sensorDto.getDesc());
    }

    public SensorDto mapToSensorDto(final Sensor sensor) {
        return new SensorDto(sensor.getId(),
                sensor.getName(),
                sensor.getType(),
                sensor.getPin(),
                sensor.getUnits(),
                sensor.getDesc());
    }

    public List<Sensor> mapToSensorList(final List<SensorDto> sensorDtoList) {
        if(sensorDtoList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return sensorDtoList.stream()
                    .map(this::mapToSensor)
                    .collect(Collectors.toList());
        }
    }

    public List<SensorDto> mapToSensorDtoList(final List<Sensor> sensorList) {
        if(sensorList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return sensorList.stream()
                    .map(this::mapToSensorDto)
                    .collect(Collectors.toList());
        }
    }
}
