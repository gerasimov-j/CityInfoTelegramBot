package by.gerasimov.service;

import by.gerasimov.model.Country;
import by.gerasimov.repo.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findOne(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country by id not found"));
    }

    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }

    public Country save(Country newCountry) {
        return countryRepository.save(newCountry);
    }

    public Country put(Country newCountry, Long id) {
        newCountry.setId(id);
        countryRepository.save(newCountry);
        return newCountry;
    }

    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    public void deleteAll() {
        countryRepository.deleteAll();
    }
}
