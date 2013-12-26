package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Race;
import play.mvc.BodyParser;
import play.mvc.Result;

import java.util.List;

import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;
import static play.mvc.Controller.request;
import static play.mvc.Results.notFound;
import static play.mvc.Results.ok;

public class RestRaceController {

    public static Result index() {
        return ok(views.html.rest.index.render());
    }

    public static Result list() {
        List<Race> races = Race.list();
        return ok(toJson(races));
    }

    public static Result details(Long id) {
        Race race = Race.findById(id);
        if (race == null) return notFound();

        return ok(toJson(race));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result update(long id) {
        Race race = getRace();
        race.update(id);
        return ok();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
        Race race = getRace();
        race.save();
        return ok();
    }

    private static Race getRace() {
        JsonNode json = request().body().asJson();
        return fromJson(json, Race.class);
    }


}
