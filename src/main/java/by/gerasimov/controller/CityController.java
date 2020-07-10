package by.gerasimov.controller;

import by.gerasimov.model.City;
import by.gerasimov.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public List<City> getAll() {
        return service.findAll();
    }

    @PostMapping
    City save(@RequestBody City newCity) {
        return service.save(newCity);
    }

    @GetMapping("{id}")
    public City getById(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("{id}")
    public City put(@RequestBody City newCity, @PathVariable Long id) {
        return service.put(newCity, id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
