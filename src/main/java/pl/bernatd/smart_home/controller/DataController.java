package pl.bernatd.smart_home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bernatd.smart_home.domain.Data;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.dto.DataDto;
import pl.bernatd.smart_home.exceptions.DataNotFoundException;
import pl.bernatd.smart_home.exceptions.SensorNotFoundException;
import pl.bernatd.smart_home.mapper.DataMapper;
import pl.bernatd.smart_home.service.DbDataService;
import pl.bernatd.smart_home.service.DbSensorService;

import java.util.List;

@RestController
@RequestMapping("/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final DbDataService dataService;

    private final DataMapper mapper;

    @GetMapping
    public ResponseEntity<List<DataDto>> getAllData() {
        List<Data> data = dataService.getAllData();
        return ResponseEntity.ok(mapper.mapToDataDtoList(data));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DataDto> getData(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(mapper.mapToDataDto(dataService.getData(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertData(@RequestBody DataDto dataDto) throws SensorNotFoundException {
        Data data = mapper.mapToDataOnPost(dataDto);
        dataService.saveData(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<DataDto> updateData(@RequestBody DataDto dataDto) throws SensorNotFoundException {
        Data data = mapper.mapToDataOnPut(dataDto);
        Data savedData = dataService.saveData(data);
        return ResponseEntity.ok(mapper.mapToDataDto(savedData));
    }

    @DeleteMapping(value = "{dataId}")
    public ResponseEntity<Void> deleteData(@PathVariable Long dataId) {
        dataService.deleteData(dataId);
        return ResponseEntity.ok().build();
    }
}
