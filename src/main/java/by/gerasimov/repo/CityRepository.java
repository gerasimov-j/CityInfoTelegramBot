package by.gerasimov.repo;

import by.gerasimov.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);
    List<City> findAllByName(String name);
}
