package pl.bernatd.smart_home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.bernatd.smart_home.domain.Data;
import pl.bernatd.smart_home.domain.Sensor;
import pl.bernatd.smart_home.repository.SensorRepository;

@SpringBootApplication
public class SmartHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHomeApplication.class, args);
	}

		@Autowired
		public SensorRepository repository;

		@Bean
		public CommandLineRunner run(SensorRepository repository) throws Exception {
			return args -> {
				Sensor sensor = new Sensor("Aqq", "Aqq", 7, "degC", "temperature");
				Data data = new Data(sensor, 23.5);
				Data data1 = new Data(sensor, 23.0);
				sensor.getData().add(data);
				sensor.getData().add(data1);
				repository.save(sensor);
				Data data2 = new Data(sensor, 18.4);
				sensor.getData().add(data2);
				repository.save(sensor);

			};
		}
}
