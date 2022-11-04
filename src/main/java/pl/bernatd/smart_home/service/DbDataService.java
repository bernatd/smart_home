package pl.bernatd.smart_home.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bernatd.smart_home.domain.Data;
import pl.bernatd.smart_home.repository.DataRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbDataService {

    @Autowired
    private DataRepository repository;

    public List<Data> getAllData() {
        return repository.findAll();
    }

    public Data saveData(final Data data) {
        return repository.save(data);
    }

    public Optional<Data> getData(Long id) {
        return repository.findById(id);
    }

    public void deleteData(Long id) {
        repository.deleteById(id);
    }
}
