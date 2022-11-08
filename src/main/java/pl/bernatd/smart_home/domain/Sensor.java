package pl.bernatd.smart_home.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String type;
    private Integer pin;
    private String units;
    private String desc;

    @OneToMany(
            targetEntity = Data.class,
            mappedBy = "sensor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Data> data = new ArrayList<>();

    public Sensor(String name, String type, Integer pin, String units, String desc) {
        this.name = name;
        this.type = type;
        this.pin = pin;
        this.units = units;
        this.desc = desc;
    }
}
