package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment extends Model {

    @Id
    public Long id;

    public String comment;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }
}
