package pl.bernatd.smart_home.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataDto {
    private Long id;
    private Date timestamp;
    private Long sensorId;
    private Double value;
}
