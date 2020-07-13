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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAll() {
        return cityService.findAll();
    }

    @PostMapping
    City save(@RequestBody City newCity) {
        return cityService.save(newCity);
    }

    @GetMapping("{id}")
    public City getById(@PathVariable Long id) {
        return cityService.findOne(id);
    }

    @PutMapping("{id}")
    public City put(@RequestBody City newCity, @PathVariable Long id) {
        return cityService.put(newCity, id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
    }
}
