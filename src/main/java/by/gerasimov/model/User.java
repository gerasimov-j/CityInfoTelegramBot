package by.gerasimov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Long chatId;
    private int queryCount;

    public void increaseQueryCount() {
        queryCount++;
    }
}
