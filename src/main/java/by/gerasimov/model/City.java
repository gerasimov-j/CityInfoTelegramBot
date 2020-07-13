package by.gerasimov.model;

import com.vdurmont.emoji.EmojiParser;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 4000)
    private String info;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public City() {

    }

    public City(String name, String info, Country country) {
        this.name = name;
        this.info = info;
        this.country = country;
    }

    public String getCountryName() {
        String name = "";
        if (country != null) {
            name = country.getName();
        }
        return name;
    }

    public String getCountryEmoji() {
        String emoji = "";
        if (country != null) {
            emoji = EmojiParser.parseToUnicode(country.getEmojiCode());
        }
        return emoji;
    }
}
