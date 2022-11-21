package pl.bernatd.smart_home.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SensorDto {
    private Long id;
    private String name;
    private String type;
    private Integer pin;
    private String units;
    private String desc;
}
