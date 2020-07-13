package by.gerasimov.repo;

import by.gerasimov.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    void deleteAll();
    Country findByName(String name);
}
