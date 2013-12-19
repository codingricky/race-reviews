package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Race extends Model {
    @Id
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String location;

    @Column(nullable = false)
    public Date date;

    @Column(nullable = false)
    public boolean isApproved;

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Rating> ratings = new ArrayList<>();

    public Race(String name, String location, Date date) {
        this.name = name;
        this.location = location;
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

    public List<Race> list() {
        return new Finder<>(Long.class, Race.class).all();
    }
}
