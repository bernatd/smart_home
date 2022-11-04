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
    @GeneratedValue
    private Long id;
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    private Double val;

    public Data(Sensor sensor, Double val) {
        this.sensor = sensor;
        this.val = val;
        this.timestamp = new Date();
    }
}
