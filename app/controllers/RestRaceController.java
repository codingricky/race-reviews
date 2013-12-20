package controllers;

import models.Race;
import play.mvc.Result;

import java.util.List;

import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

public class RestRaceController {

    public static Result index() {
        return ok(views.html.rest.index.render());
    }

    public static Result list() {
        List<Race> races = Race.list();
        return ok(toJson(races));
    }

}
