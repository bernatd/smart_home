package pl.bernatd.smart_home.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.smart_home.domain.Data;
import pl.bernatd.smart_home.dto.DataDto;
import pl.bernatd.smart_home.exceptions.SensorNotFoundException;
import pl.bernatd.smart_home.service.DbSensorService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataMapper {
    @Autowired
    private DbSensorService sensorService;

    public DataDto mapToDataDto(final Data data) {
        return new DataDto(data.getId(),
                data.getTimestamp(),
                data.getSensor().getId(),
                data.getValue());
    }

    public List<DataDto> mapToDataDtoList(List<Data> data) {
        if(data.isEmpty()) {
            return new ArrayList<>();
        } else {
            return data.stream()
                    .map(this::mapToDataDto)
                    .collect(Collectors.toList());
        }
    }

    public Data mapToDataOnPost(final DataDto dataDto) throws SensorNotFoundException {
        return new Data(dataDto.getId(),
                new Date(),
                sensorService.getSensor(dataDto.getSensorId()),
                dataDto.getValue());
    }

    public Data mapToDataOnPut(final DataDto dataDto) throws SensorNotFoundException {
        return new Data(dataDto.getId(),
                dataDto.getTimestamp(),
                sensorService.getSensor(dataDto.getSensorId()),
                dataDto.getValue());
    }
}
