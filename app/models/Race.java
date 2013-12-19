package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Race extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String state;

    @Constraints.Required
    public String suburb;

    @Constraints.Required
    public Date date;

    @Column(nullable = false)
    public boolean isApproved;

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Rating> ratings = new ArrayList<>();

    public Race(String name, String state, String suburb, Date date) {
        this.name = name;
        this.state = state;
        this.suburb = suburb;
        this.date = date;
        this.isApproved = false;
    }

    public Race() {
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public void approve() {
        this.isApproved = true;
    }

    public static List<Race> list() {
        return new Finder<>(Long.class, Race.class).all();
    }

    public static Race findById(Long id) {
        return new Finder<>(Long.class, Race.class).byId(id);
    }
}
