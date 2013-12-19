package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

public class RaceController  {

    public static Result races() {
        return ok(views.html.race.newRace.render());
    }

    public static Result newRace() {
        return null;
    }

    public static Result deleteRace(Long id) {
        return null;
    }
}
