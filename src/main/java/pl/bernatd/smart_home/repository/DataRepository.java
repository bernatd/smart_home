package pl.bernatd.smart_home.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bernatd.smart_home.domain.Data;

import java.util.List;

public interface DataRepository extends CrudRepository<Data, Long> {
    List<Data> findAll();
}
