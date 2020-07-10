package by.gerasimov.service;

import by.gerasimov.model.City;
import by.gerasimov.repo.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAllByName(String name) {
        return cityRepository.findAllByName(name);
    }

    public City findOne(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City by id not found"));
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City save(City newCity) {
        return cityRepository.save(newCity);
    }

    public City put(City newCity, Long id) {
        newCity.setId(id);
        cityRepository.save(newCity);
        return newCity;
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
