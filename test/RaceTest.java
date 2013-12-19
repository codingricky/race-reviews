import models.Comment;
import models.Race;
import models.Rating;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class RaceTest {

    @Before
    public void before() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void create() {
        Race race = createDummyRace();
        race.save();
        assertThat(race.id).isNotNull();
        assertThat(race.name).isNotNull();
        assertThat(race.state).isNotNull();
        assertThat(race.suburb).isNotNull();
        assertThat(race.date).isNotNull();
        assertThat(race.isApproved).isFalse();
    }

    @Test
    public void addComment() {
        Race race = createDummyRace();
        Comment comment = new Comment("Some comment");
        race.addComment(comment);
        race.save();

        assertThat(comment.id).isNotNull();
        assertThat(race.comments.size()).isEqualTo(1);
    }

    @Test
    public void addRating() {
        Race race = createDummyRace();
        Rating rating = new Rating();
        race.addRating(rating);
        race.save();

        assertThat(rating.id).isNotNull();
        assertThat(race.ratings.size()).isEqualTo(1);
    }

    @Test
    public void approveRace() {
        Race race = createDummyRace();
        race.save();

        race.approve();

        assertThat(race.isApproved).isTrue();
    }

    private static Race createDummyRace() {
        return new Race("SMH Half Marathon", "NSW", "Sydney", new Date());
    }
}
