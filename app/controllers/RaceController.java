package controllers;

import models.Race;
import play.data.Form;
import play.mvc.Result;

import java.util.List;

import static play.mvc.Controller.flash;
import static play.mvc.Results.*;

public class RaceController {

    private static final Form<Race> raceForm = Form.form(Race.class);

    public static Result races() {
        List<Race> races = Race.list();
        return ok(views.html.race.races.render(races));
    }

    public static Result create() {
        Form<Race> boundForm = raceForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            flash("errors", "Please correct the form below.");
            return badRequest(views.html.race.details.render(boundForm, routes.RaceController.create()));
        }
        Race race = boundForm.get();
        race.save();
        return redirect(routes.RaceController.races());
    }

    public static Result update(Long id) {
        Form<Race> boundForm = raceForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            flash("errors", "Please correct the form below.");
            return badRequest(views.html.race.details.render(boundForm, routes.RaceController.update(id)));
        }
        Race race = boundForm.get();
        race.update(id);
        return redirect(routes.RaceController.races());
    }

    public static Result details(Long id) {
        Race race = Race.findById(id);
        Form<Race> filledForm = raceForm.fill(race);
        return ok(views.html.race.details.render(filledForm, routes.RaceController.update(id)));
    }

    public static Result newRace() {
        return ok(views.html.race.details.render(raceForm, routes.RaceController.create()));
    }

    public static Result delete(Long id) {
        Race.findById(id).delete();
        return redirect(routes.RaceController.races());
    }
}
