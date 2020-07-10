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
    @GeneratedValue
    private long id;
    private String name;
    private String emojiCode;
}