package by.gerasimov.controller;

import by.gerasimov.model.Country;
import by.gerasimov.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @PostMapping
    Country save(@RequestBody Country newCountry) {
        return countryService.save(newCountry);
    }

    @GetMapping("{id}")
    public Country getById(@PathVariable Long id) {
        return countryService.findOne(id);
    }

    @PutMapping("{id}")
    public Country put(@RequestBody Country newCountry, @PathVariable Long id) {
        newCountry.setId(id);
        countryService.save(newCountry);
        return newCountry;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
