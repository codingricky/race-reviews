package controllers;

import models.Race;
import play.data.Form;
import play.mvc.Result;

import java.util.List;

import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

public class RaceController  {

    private static final Form<Race> raceForm = Form.form(Race.class);

    public static Result races() {
        List<Race> races = Race.list();
        return ok(views.html.race.races.render(races));
    }

    public static Result save() {
        Form<Race> boundForm = raceForm.bindFromRequest();
        Race race = boundForm.get();
        race.save();
        return redirect(routes.RaceController.races());
    }

    public static Result details(Long id) {
        return null;
    }

    public static Result newRace() {
        return ok(views.html.race.newRace.render(raceForm));
    }

    public static Result deleteRace(Long id) {
        return null;
    }
}
