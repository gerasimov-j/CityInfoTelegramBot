package by.gerasimov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String emojiCode;

    public Country() {

    }

    public Country(String name, String emojiCode) {
        this.name = name;
        this.emojiCode = emojiCode;
    }
}
