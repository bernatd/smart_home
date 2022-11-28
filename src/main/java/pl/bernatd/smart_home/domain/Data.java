package pl.bernatd.smart_home.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    @Column(name = "\"value\"")
    private Double value;

    public Data(Sensor sensor, Double value) {
        this.sensor = sensor;
        this.value = value;
        this.timestamp = new Date();
    }
}
