package by.gerasimov.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String info;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public String getCountryName() {
        return country.getName();
    }

    public String getCountryEmojiCode() {
        return country.getEmojiCode();
    }
}
