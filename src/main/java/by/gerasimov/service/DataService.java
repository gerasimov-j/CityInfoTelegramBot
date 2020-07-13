package by.gerasimov.service;

import by.gerasimov.model.City;
import by.gerasimov.model.Country;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    private String getStringFromResourceFile(String fileName) {
        String out = "";
        try {
            out = new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public void generateCountries() {
        String jsonText = getStringFromResourceFile("data/json/countries.json");
        JSONArray jsonCountries = new JSONArray(jsonText);
        Country country;
        for (int i = 0; i < jsonCountries.length(); i++) {
            JSONObject jsonCountry = jsonCountries.getJSONObject(i);
            country = new Country(
                jsonCountry.getString("name"),
                jsonCountry.getString("emojiCode")
            );
            countryService.save(country);
        }
    }

    public void generateCities() {
        String jsonText = getStringFromResourceFile("data/json/cities.json");
        JSONArray jsonCities = new JSONArray(jsonText);
        City city;
        for (int i = 0; i < jsonCities.length(); i++) {
            JSONObject jsonCity = jsonCities.getJSONObject(i);
            city = new City(
                jsonCity.getString("name"),
                jsonCity.getString("info"),
                countryService.findByName(jsonCity.getJSONObject("country").getString("name"))
            );
            cityService.save(city);
        }
    }

    public void generateData() {
        cityService.deleteAll();
        countryService.deleteAll();
        generateCountries();
        generateCities();
    }
}
