package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    public Long id;

    private int rating;

    public Rating() {
    }

    public Rating(int rating) {
        this.rating = rating;
    }
}
